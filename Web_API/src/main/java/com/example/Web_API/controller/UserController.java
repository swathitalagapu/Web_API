package com.example.Web_API.controller;

import com.example.Web_API.Entity.User;
import com.example.Web_API.exception.NoDataFoundException;
import com.example.Web_API.repository.UserRepository;
import com.example.Web_API.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user/create")
    public ResponseEntity<User> createStudent(@RequestBody User user) {
       userService.createUserDetails(user);
       return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getSingleUserDetails(@PathVariable long id) throws NoDataFoundException {
        Optional<User> user = userService.getSingleUserDetails(id);
        if(user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/users")
    public List<User> getAllUsersDetails(){
        return userService.getAllUsersDetails();

    }
}
