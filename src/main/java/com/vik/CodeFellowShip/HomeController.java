package com.vik.CodeFellowShip;

import com.vik.CodeFellowShip.models.ApplicationUser;
import com.vik.CodeFellowShip.models.ApplicationUserRepository;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class HomeController {

    // interface to database
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    // password encoder: this can be autowired because there is a bean in websecurityconfig
    // used to encode password on instantiation of username info on signup page
    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/")
    // model m to pass in variables
    public String getHome(Principal p, Model m) {
        // take in Principal p (how we get access to person currently logged in), check if not null, then print name of principal
        if (p != null) {
            System.out.println(p.getName());
            // p's name passed in, then using database repo to get username to pass it in
            ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
            System.out.println(user);
            m.addAttribute("user", user);
        } else {
            System.out.println("nobody logged in");
        }
        return "home";
    }

    @GetMapping("/signup")
    public String getSignup() {
        return "signup";
    }

    @PostMapping("/signup")
    public RedirectView signup(String username, String password, String firstName, String lastName, String dob, String bio) {
        // instantiate ApplicationUser and use encoder on password
        ApplicationUser newUser = new ApplicationUser(username, encoder.encode(password), firstName, lastName, dob, bio);
        // save to database
        applicationUserRepository.save(newUser);
        return new RedirectView("/");
    }

    @GetMapping("/login")
    public String getLogin() {return "login"; }

    // postmapping for login handled by spring security

    // getmapping for logout handled by spring - by default goes to login page

    @GetMapping("/myprofile")
    public String getProfile() {return "myprofile"; }
}
