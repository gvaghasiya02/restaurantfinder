package com.scu.restaurantfinder.model;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String pincode;

    @Column(nullable = false)
    private String cuisine;

    @Column(nullable = false)
    private Double priceRange;  // Assume average price for two

    @Column(nullable = false)
    private double avgRating = 0.0;  // Scale 1-5

    private String contactEmail;
    private String contactPhone;
    private String openingHours;
    private String description;
    private String menu;

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPincode() {
        return pincode;
    }

    public String getCuisine() {
        return cuisine;
    }

    public Double getPriceRange() {
        return priceRange;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public String getMenu() {
        return menu;
    }

    public String getDescription() { return description; }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public void setPriceRange(Double priceRange) {
        this.priceRange = priceRange;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public void setDescription(String description) { this.description = description; }
}
