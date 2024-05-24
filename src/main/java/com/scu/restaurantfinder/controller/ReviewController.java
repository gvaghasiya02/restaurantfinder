package com.scu.restaurantfinder.controller;

import com.scu.restaurantfinder.model.Review;
import com.scu.restaurantfinder.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/")
    public Review addReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    // More endpoints as necessary
}
