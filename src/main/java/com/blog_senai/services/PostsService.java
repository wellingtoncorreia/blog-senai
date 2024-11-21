package com.blog_senai.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog_senai.entities.Posts;
import com.blog_senai.repository.PostsRepository;


@Service
public class PostsService {
	 @Autowired
	    private PostsRepository postsRepository;

	    public PostsService(PostsRepository postsRepository) {
	        this.postsRepository = postsRepository;
	    }

	    public List<Posts> getAllPosts() {
	        return postsRepository.findAll();
	    }

	    public Posts getPostById(Long id) {
	        Optional<Posts> existingPost = postsRepository.findById(id);
	        return existingPost.orElse(null);
	    }

	    public Posts createPost(Posts post) {
	        return postsRepository.save(post);
	    }

	    public Posts updatePost(Long id, Posts updatedPost) {
	        Optional<Posts> existingPost = postsRepository.findById(id);
	        if (existingPost.isPresent()) {
	            updatedPost.setId(id);
	            return postsRepository.save(updatedPost);
	        }
	        return null;
	    }

	    public boolean deletePost(Long id) {
	        Optional<Posts> existingPost = postsRepository.findById(id);
	        if (existingPost.isPresent()) {
	            postsRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
}
