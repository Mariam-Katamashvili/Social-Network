package com.mariam.social_media_app;

import com.mariam.social_media_app.repository.PostRepo;
import com.mariam.social_media_app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocialMediaAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialMediaAppApplication.class, args);
    }

    @Autowired
    UserRepo userRepo;

    @Autowired
    PostRepo postRepo;
}
