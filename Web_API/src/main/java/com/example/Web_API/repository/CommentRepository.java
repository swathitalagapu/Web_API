package com.example.Web_API.repository;

import com.example.Web_API.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Optional<Comment> deleteByUserId(int userId);

    Optional<Comment> findByUserId(int userId);
}
