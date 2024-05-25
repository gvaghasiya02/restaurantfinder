package com.scu.restaurantfinder.controller;

import com.scu.restaurantfinder.model.Restaurant;
import com.scu.restaurantfinder.model.Review;
import com.scu.restaurantfinder.service.RestaurantService;
import com.scu.restaurantfinder.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/")
    public List<Review> getAllReviews() {
        return reviewService.findAllReviews();
    }

    @PostMapping("/add")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review savedReview = reviewService.saveReview(review);
        Long id=savedReview.getRestaurantId();
        List<Review> reviews=getReviews(id);
        Double sum=0.0;
        for(Review rr:reviews)
        {
            sum=sum+rr.getRating();
        }
        sum=sum/reviews.size();
        restaurantService.updateRatings(id,sum);

        return ResponseEntity.ok(savedReview);
    }

    @GetMapping("/{restaurantId}")
    public List<Review> getReviews(@PathVariable Long restaurantId) {
        return reviewService.getReviewsByRestaurantId(restaurantId);
    }
    // More endpoints as necessary
}
