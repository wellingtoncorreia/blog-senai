package com.blog_senai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog_senai.entities.Posts;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
