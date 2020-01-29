package com.vik.CodeFellowShip.models;

import org.springframework.data.jpa.repository.JpaRepository;

// create this repository that will help make a table in database for application user info

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    // get username with repository; this can throw errors if two entries in database have the same username
    ApplicationUser findByUsername(String username);
}
