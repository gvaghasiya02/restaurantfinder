package com.scu.restaurantfinder.model;

public class SignUpRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean isAdmin;

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsAdmin() {  // Follow Java naming conventions for boolean getters
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {  // Modified to accept a parameter to set the value
        this.isAdmin = isAdmin;
    }
}