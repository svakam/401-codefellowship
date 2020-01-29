package com.vik.CodeFellowShip.security;

import com.vik.CodeFellowShip.models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// implement methods used by user details service
// will originally show error line, but import the methods with alt enter

// once authenticationmanagerbuilder commented back in, need to say userdetailsserviceimpl is a service
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    // loads user by user name from database: instantiate repository that deals with getting user info, then get username
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // originally returning application user, but must return UserDetails; make it so applicationuser implements user details interface
        // alt+enter on error below, which will give application user methods to return user details
        return applicationUserRepository.findByUsername(username);
    }
}
