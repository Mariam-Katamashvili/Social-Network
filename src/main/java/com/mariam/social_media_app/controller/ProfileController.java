package com.mariam.social_media_app.controller;

import com.mariam.social_media_app.model.Post;
import com.mariam.social_media_app.service.PostService;
import com.mariam.social_media_app.service.UserService;
import org.springframework.ui.Model;
import com.mariam.social_media_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProfileController {
    private final UserService userService;
    private final PostService postService;

    @Autowired
    public ProfileController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping("/profile/{userId}")
    private String getUserProfile(@PathVariable int userId, Model model) {
        User user = userService.findByUserId(userId);
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        List<Post> posts = postService.findByUserOrderByDateDesc(user);
        model.addAttribute("posts", posts);
        return "profileView";
    }

    @PostMapping("/profile/{userId}")
    private String addPost(@PathVariable int userId,
                           @RequestParam String content,
                           RedirectAttributes redirectAttributes) {
        User user = userService.findByUserId(userId);
        try {
            Post post = new Post(content, user);
            postService.savePost(post);
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/profile/" + userId;
        }
        return "redirect:/profile/" + userId;
    }
}
