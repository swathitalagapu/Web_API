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

    public Optional<Comment> createComment(Comment comment, int userId) {
        Optional<Comment> comment1 = userRepository.findByUserId(userId).map(user -> {
            comment.setUser(user);
            return commentRepository.save(comment);
        });
        return comment1;

    }

    //    public void deleteComment(int userId){
//        Optional<Comment> comment =commentRepository.findByUserId(userId);
//        if(comment.isPresent()){
//            commentRepository.deleteByUserId(userId);
//        }else {
//            throw new RuntimeException("no data found");
//        }
//    }
    public void deleteComment(int id) {
        commentRepository.deleteById(id);
    }

    public Optional<Comment> getSingleComment(Integer id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isPresent()){
            return comment;
        }
        else{
            throw new RuntimeException("no data present");
        }
    }
}
