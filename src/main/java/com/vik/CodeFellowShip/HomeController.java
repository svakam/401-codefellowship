package com.vik.CodeFellowShip;

import com.vik.CodeFellowShip.models.ApplicationUser;
import com.vik.CodeFellowShip.models.ApplicationUserRepository;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {

    // interface to database
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    // password encoder: this can be autowired because there is a bean in websecurityconfig
    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/")
    public String getHome() {
        return "home";
    }

    @GetMapping("/signup")
    public String getSignup() {
        return "signup";
    }

    @PostMapping("/signup")
    public RedirectView signup(String username, String password, String firstName) {
        // instantiate ApplicationUser and use encoder on password
        ApplicationUser newUser = new ApplicationUser(username, encoder.encode(password), firstName);
        // save to database
        applicationUserRepository.save(newUser);
        return new RedirectView("/");
    }

    @GetMapping("/login")
    public String getLogin() {return "login"; }
}
