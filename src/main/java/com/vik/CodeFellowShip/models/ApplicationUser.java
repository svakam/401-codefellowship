package com.vik.CodeFellowShip.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String username;
    String password;
    String firstName;

    public ApplicationUser() {}

    public ApplicationUser(String username, String password, String firstName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
    }
}
