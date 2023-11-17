package com.mariam.social_media_app.controller;

import com.mariam.social_media_app.model.Post;
import com.mariam.social_media_app.repository.PostRepo;
import org.springframework.ui.Model;
import com.mariam.social_media_app.model.User;
import com.mariam.social_media_app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProfileController {
    private UserRepo userRepo;
    private PostRepo postRepo;

    @Autowired
    public ProfileController (UserRepo userRepo, PostRepo postRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
    }

    @GetMapping("/profile/{userId}")
    private String getUserProfile(@PathVariable int userId,
                                  Model model) {
        User user = userRepo.findByUserId(userId);
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        List<Post> posts = postRepo.findByUserOrderByDateDesc(user);
        model.addAttribute("posts", posts);
        return "profileView";
    }

    @PostMapping("/profile/{userId}")
    private String addPost(@PathVariable int userId,
                           @RequestParam String content,
                           Model model,
                           RedirectAttributes redirectAttributes) {
        User user = userRepo.findByUserId(userId);
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        if (content == null || content.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Post content cannot be empty.");
            return "redirect:/profile/" + userId;
        } else {
            Post post = new Post(content, user);
            postRepo.save(post);
        }
        return "redirect:/profile/" + userId;
    }

}
