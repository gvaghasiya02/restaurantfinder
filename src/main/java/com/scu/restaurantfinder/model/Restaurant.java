package com.scu.restaurantfinder.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    private String contactInfo;
    private String openingHours;
    private String menu;
    private String cuisine;
    private Double priceRange;  // Assume average price for two


    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getContactInfo() { return contactInfo; }
    public String getOpeningHours() { return openingHours; }
    public String getMenu() { return menu; }
    public String getCuisine() { return cuisine; }
    public Double getPriceRange() { return priceRange; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
    public void setOpeningHours(String openingHours) { this.openingHours = openingHours; }
    public void setMenu(String menu) { this.menu = menu; }
    public void setCuisine(String cuisine) { this.cuisine = cuisine; }
    public void setPriceRange(Double priceRange) { this.priceRange = priceRange; }

}