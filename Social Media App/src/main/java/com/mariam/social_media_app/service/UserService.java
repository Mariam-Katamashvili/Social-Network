package com.mariam.social_media_app.service;

import com.mariam.social_media_app.model.User;

import java.util.List;

public interface UserService {
    User findByUserId(int userId);

    User findByEmail(String email);

    List<User> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);

    User registerNewUser(String firstName, String lastName, String email, String password);

    User authenticateUser(String email, String password);

}