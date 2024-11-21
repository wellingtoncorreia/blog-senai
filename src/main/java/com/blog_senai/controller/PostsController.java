package com.blog_senai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog_senai.entities.Posts;
import com.blog_senai.services.PostsService;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "*")
public class PostsController {

    @Autowired
    private PostsService postsService;

    @GetMapping
    public List<Posts> getAllPosts() {
        return postsService.getAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Posts> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postsService.getPostById(id));
    }

    @PostMapping
    public ResponseEntity<Posts> createPost(@RequestBody Posts post) {
        return ResponseEntity.ok(postsService.createPost(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Posts> updatePost(@PathVariable Long id, @RequestBody Posts updatedPost) {
        return ResponseEntity.ok(postsService.updatePost(id, updatedPost));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postsService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
