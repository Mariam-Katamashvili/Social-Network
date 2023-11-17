package com.mariam.social_media_app.serviceImpl;

import com.mariam.social_media_app.model.Post;
import com.mariam.social_media_app.model.User;
import com.mariam.social_media_app.repository.PostRepo;
import com.mariam.social_media_app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepo postRepo;

    @Autowired
    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public List<Post> findByUserOrderByDateDesc(User user) {
        return postRepo.findByUserOrderByDateDesc(user);
    }

    @Override
    public List<Post> findAllByOrderByDateDesc() {
        return postRepo.findAllByOrderByDateDesc();
    }

    @Override
    public void savePost(Post post) throws IllegalArgumentException {
        if (post.getText() == null || post.getText().trim().isEmpty()) {
            throw new IllegalArgumentException("Post content cannot be empty.");
        }
        postRepo.save(post);
    }
}
