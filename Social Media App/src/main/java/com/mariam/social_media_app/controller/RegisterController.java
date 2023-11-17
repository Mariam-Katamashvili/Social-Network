package com.mariam.social_media_app.controller;

import com.mariam.social_media_app.model.User;
import com.mariam.social_media_app.repository.UserRepo;
import com.mariam.social_media_app.service.UserService;
import com.mariam.social_media_app.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    private UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
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
                                     Model model) {

        if (!password.equals(repeatPassword)) {
            model.addAttribute("error", "Passwords do not match.");
            model.addAttribute("firstName", firstName);
            model.addAttribute("lastName", lastName);
            model.addAttribute("email", email);
            return "register";
        }

        try {
            userService.registerNewUser(firstName, lastName, email, password);
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Email already exists.");
            model.addAttribute("firstName", firstName);
            model.addAttribute("lastName", lastName);
            return "register";
        }
        return "redirect:/index";
    }

}