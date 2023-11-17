package com.mariam.social_media_app.controller;

import com.mariam.social_media_app.model.Post;
import com.mariam.social_media_app.model.User;
import com.mariam.social_media_app.repository.PostRepo;
import com.mariam.social_media_app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TimelineController {
    private UserRepo userRepo;
    private PostRepo postRepo;

    @Autowired
    public TimelineController(UserRepo userRepo, PostRepo postRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
    }

    @GetMapping("/timeline/{userId}")
    public String getUserTimeline(@PathVariable int userId, Model model) {
        User user = userRepo.findByUserId(userId);
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        List<Post> posts = postRepo.findAllByOrderByDateDesc();
        model.addAttribute("posts", posts);
        return "timelineView";

    }

}
