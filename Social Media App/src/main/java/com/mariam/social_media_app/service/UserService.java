package com.mariam.social_media_app.service;

import com.mariam.social_media_app.model.User;

public interface UserService {
    User findByUserId(int userId);
    User findByEmail(String email);
}