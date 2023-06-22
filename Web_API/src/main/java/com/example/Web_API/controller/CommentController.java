package com.example.Web_API.controller;

import com.example.Web_API.Entity.Comment;
import com.example.Web_API.service.CommentService;
import com.example.Web_API.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

   @DeleteMapping("/deleteComment")
    public void deleteComment(@PathVariable int id){
        commentService.deleteComment(id);
   }

   @GetMapping("/comment/{id}")
    public ResponseEntity<Comment> getSingleComment(@PathVariable Integer id) {
       Optional<Comment> comment = commentService.getSingleComment(id);
       return new ResponseEntity<>(comment.get(), HttpStatus.OK);
   }

//   @GetMapping("/user/{userId}/comments")
//    public ResponseEntity<List<Comment>> getAllUsersByComments(){
//
//   }
}
