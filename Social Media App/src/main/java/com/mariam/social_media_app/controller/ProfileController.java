package com.mariam.social_media_app.controller;

import org.springframework.ui.Model;
import com.mariam.social_media_app.model.User;
import com.mariam.social_media_app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {
    private UserRepo userRepo;

    @Autowired
    public ProfileController (UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/profile/{userId}")
    private String getUserProfile(@PathVariable int userId, Model model) {
        User user = userRepo.findByUserId(userId);
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        return "profileView";
    }
}
