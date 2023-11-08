package com.mariam.social_media_app.repository;

import com.mariam.social_media_app.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    User findByUserId(int userId);
}
