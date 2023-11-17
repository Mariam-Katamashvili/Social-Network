package com.mariam.social_media_app.controller;

import com.mariam.social_media_app.model.User;
import com.mariam.social_media_app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/register")
    public String handleRegistration(@RequestParam String firstName,
                                     @RequestParam String lastName,
                                     @RequestParam String email,
                                     @RequestParam String password,
                                     @RequestParam String repeatPassword,
                                     Model model){

        if (!password.equals(repeatPassword)) {
            model.addAttribute("error", "Passwords do not match.");
            model.addAttribute("firstName", firstName);
            model.addAttribute("lastName", lastName);
            model.addAttribute("email", email);
            return "register";
        }

        try {
            User newUser = new User(firstName, lastName, email, password);
            userRepo.save(newUser);
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Email already exists.");
            model.addAttribute("firstName", firstName);
            model.addAttribute("lastName", lastName);
            return "register";
        }
        return "redirect:/index";
    }
}