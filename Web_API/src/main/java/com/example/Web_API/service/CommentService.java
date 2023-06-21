package com.example.Web_API.service;

import com.example.Web_API.Entity.Comment;
import com.example.Web_API.repository.CommentRepository;
import com.example.Web_API.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CommentRepository commentRepository;

    public Comment createComment(Comment comment, int userId){
        Optional<Object> comment1 =userRepository.findById((long) userId).map(user -> {
            comment.setUser(user);
            return commentRepository.save(comment);
        });
        return comment;

    }
}
