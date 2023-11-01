package com.example.deliveryapplication.data;

import java.io.Serializable;

public  class UserInfo implements Serializable {
    private String prenom;
    private String nom;
    private String email;
    private String password;
    private String phoneNumber;

    // Constructor
    public UserInfo(String prenom, String nom, String email, String password, String phoneNumber) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
    public String getPrenom() {
        return prenom;
    }
    public String getNom() {
        return nom;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
}