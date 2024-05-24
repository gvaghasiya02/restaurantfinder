package com.scu.restaurantfinder.model;

import jakarta.persistence.*;


@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(nullable = false)
    private Long userId;  // Assuming User ID from User table

    private String text;
    private int rating;  // Scale 1-5

    // Constructors, Getters, Setters
}
