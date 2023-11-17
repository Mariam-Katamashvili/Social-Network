package com.mariam.social_media_app.controller;


import com.mariam.social_media_app.model.User;
import com.mariam.social_media_app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {
    private UserRepo userRepo;

    @Autowired
    public SearchController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/search")
    public String searchUsers(@RequestParam(name = "query") String query, Model model) {
        List<User> users = userRepo.findByFirstNameContainingOrLastNameContaining(query, query);
        model.addAttribute("searchResults", users);
        return "searchView";
    }
}
