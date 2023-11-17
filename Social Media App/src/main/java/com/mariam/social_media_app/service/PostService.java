package com.mariam.social_media_app.service;

import com.mariam.social_media_app.model.Post;
import com.mariam.social_media_app.model.User;

import java.util.List;

public interface PostService {
    List<Post> findByUserOrderByDateDesc(User user);

    List<Post> findAllByOrderByDateDesc();
    void savePost(Post post);
}