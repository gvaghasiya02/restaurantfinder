package com.scu.restaurantfinder.repository;

import com.scu.restaurantfinder.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Custom queries for fetching reviews based on restaurant or user
    List<Review> findByRestaurantId(Long restaurantId);
}
