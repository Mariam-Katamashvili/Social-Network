//package com.mariam.social_media_app.serviceImpl;
//
//import com.mariam.social_media_app.model.User;
//import com.mariam.social_media_app.repository.UserRepo;
//import com.mariam.social_media_app.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    private UserRepo userRepo;
//
//    @Autowired
//    public UserServiceImpl(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }
//
//    @Override
//    public User getUserById(int userId) {
//        return userRepo.findById(userId).orElse(null);
//    }
//}
