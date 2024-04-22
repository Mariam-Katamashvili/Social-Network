package com.mariam.social_media_app.controller;

import com.mariam.social_media_app.model.Post;
import com.mariam.social_media_app.model.User;
import com.mariam.social_media_app.service.PostService;
import com.mariam.social_media_app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TimelineController {
    private UserService userService;
    private PostService postService;

    public TimelineController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping("/timeline/{userId}")
    public String getUserTimeline(@PathVariable int userId, Model model) {
        User user = userService.findByUserId(userId);
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        List<Post> posts = postService.findAllByOrderByDateDesc();
        model.addAttribute("posts", posts);
        return "timelineView";
    }
}