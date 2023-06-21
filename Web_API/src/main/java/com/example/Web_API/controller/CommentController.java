package com.example.Web_API.controller;

import com.example.Web_API.Entity.Comment;
import com.example.Web_API.service.CommentService;
import com.example.Web_API.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;

    @PostMapping("/user/{userId}/comments")
    public ResponseEntity<Comment> createComment(@PathVariable int userId, @RequestBody Comment comment){
        commentService.createComment(comment,userId);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }
}
