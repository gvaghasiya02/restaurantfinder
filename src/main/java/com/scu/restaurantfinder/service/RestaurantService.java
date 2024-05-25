package com.scu.restaurantfinder.service;

import com.scu.restaurantfinder.model.Restaurant;
import com.scu.restaurantfinder.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> findAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> findRestaurantById(Long id) {
        return restaurantRepository.findById(id);
    }

    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public void updateRatings(Long id, Double sum) {
        Optional<Restaurant> restaurantOptional = findRestaurantById(id);
        if (restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            restaurant.setAvgRating(sum);
            restaurantRepository.save(restaurant);
        }
    }
}
