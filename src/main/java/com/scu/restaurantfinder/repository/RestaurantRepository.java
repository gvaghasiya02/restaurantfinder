package com.scu.restaurantfinder.repository;

import com.scu.restaurantfinder.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    // Add custom database queries if necessary
}
