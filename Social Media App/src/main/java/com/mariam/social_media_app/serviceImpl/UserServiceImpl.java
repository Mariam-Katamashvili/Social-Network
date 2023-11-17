package com.mariam.social_media_app.serviceImpl;

import com.mariam.social_media_app.model.User;
import com.mariam.social_media_app.repository.UserRepo;
import com.mariam.social_media_app.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    @Override
    public User findByUserId(int userId) {
        return userRepo.findByUserId(userId);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }


}
