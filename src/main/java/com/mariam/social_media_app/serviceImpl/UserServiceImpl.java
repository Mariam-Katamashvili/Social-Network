package com.mariam.social_media_app.serviceImpl;

import com.mariam.social_media_app.model.User;
import com.mariam.social_media_app.repository.UserRepo;
import com.mariam.social_media_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User findByUserId(int userId) {
        return userRepo.findByUserId(userId);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public List<User> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName) {
        return userRepo.findByFirstNameContainingOrLastNameContaining(firstName, lastName);
    }

    @Override
    public User registerNewUser(String firstName, String lastName, String email, String password) {
        if (findByEmail(email) != null) {
            throw new DataIntegrityViolationException("Email already exists");
        }
        User newUser = new User(firstName, lastName, email, password);
        return userRepo.save(newUser);
    }

    @Override
    public User authenticateUser(String email, String password) {
        User user = userRepo.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

}