package com.scu.restaurantfinder.controller;

import com.scu.restaurantfinder.model.Restaurant;
import com.scu.restaurantfinder.model.Review;
import com.scu.restaurantfinder.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/")
    public Review addReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    @PostMapping("/add")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review savedReview = reviewService.saveReview(review);
        return ResponseEntity.ok(savedReview);
    }

    @GetMapping("/{restaurantId}")
    public List<Review> getReviews(@PathVariable Long restaurantId) {
        return reviewService.getReviewsByRestaurantId(restaurantId);
    }
    // More endpoints as necessary
}
