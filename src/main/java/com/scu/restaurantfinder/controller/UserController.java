package com.scu.restaurantfinder.controller;

import com.scu.restaurantfinder.model.LoginRequest;
import com.scu.restaurantfinder.model.User;
import com.scu.restaurantfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;


    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            logger.info("Creating user: {}", user.getEmail());
            userService.createUser(user);
            return new ResponseEntity<>("Account created successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            logger.error("Error creating user: {}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        logger.info("Authenticating user: {}", loginRequest.getEmail());
        User authenticatedUser = userService.authenticateUser(loginRequest);
        if (authenticatedUser != null) {
            logger.info("User authenticated: {}", authenticatedUser.getEmail());
            return ResponseEntity.ok(Map.of(
                    "firstName", authenticatedUser.getFirstName() != null ? authenticatedUser.getFirstName() : "",
                    "userId", authenticatedUser.getId() != null ? (""+authenticatedUser.getId()) : ""
            ));
        } else {
            logger.warn("Authentication failed for user: {}", loginRequest.getEmail());
            return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        logger.info("Logging out user");
        session.invalidate();
        return new ResponseEntity<>("User logged out successfully", HttpStatus.OK);
    }

}