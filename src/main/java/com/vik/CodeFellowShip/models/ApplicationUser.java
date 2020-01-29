package com.vik.CodeFellowShip.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// class for application user info that will be stored to database: need @Entity, @Id, @GeneratedValue, Long id, empty constructor, constructor
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
