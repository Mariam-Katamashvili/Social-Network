package com.mariam.social_media_app.repository;

import com.mariam.social_media_app.model.Post;
import com.mariam.social_media_app.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Post, Integer> {
    List<Post> findByUserOrderByDateDesc(User user);

    List<Post> findAllByOrderByDateDesc();
}
