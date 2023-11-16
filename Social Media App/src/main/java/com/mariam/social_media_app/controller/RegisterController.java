package com.mariam.social_media_app.controller;

import com.mariam.social_media_app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {
    private UserRepo userRepo;

    @Autowired
    public RegisterController (UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/register")
    public String registerUser() {
        return "register";
    }
}
