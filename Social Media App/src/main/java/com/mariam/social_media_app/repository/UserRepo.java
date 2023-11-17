package com.mariam.social_media_app.repository;

import com.mariam.social_media_app.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    User findByUserId(int userId);
    User findByEmail(String email);
    List<User> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);

}
