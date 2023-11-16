package com.mariam.social_media_app.controller;

import com.mariam.social_media_app.model.User;
import com.mariam.social_media_app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final UserRepo userRepo;

    @Autowired
    public LoginController (UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/index")
    public String showLogin() {
        return "index";
    }
    @PostMapping("/login")
    public String userLogin(@RequestParam String email,
                           @RequestParam String password,
                            Model model) {
        User user = userRepo.findByEmail(email);

        if (user == null) {
            model.addAttribute("error", "Email is incorrect or does not exist.");
            return "index";
        } else if (!user.getPassword().equals(password)) {
            model.addAttribute("error", "Password is incorrect.");
            return "index";
        }
        return "redirect:/timeline/" + user.getUserId();
    }
}
