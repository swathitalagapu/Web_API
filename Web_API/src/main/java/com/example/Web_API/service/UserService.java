package com.example.Web_API.service;

import com.example.Web_API.Entity.User;
import com.example.Web_API.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUserDetails(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getSingleUserDetails(long id) {
            Optional<User> user = userRepository.findById(id);
        try{
            if (user.isPresent()) {
                return user;
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }

        return user;
    }

    public List<User> getAllUsersDetails(){
        return userRepository.findAll();
    }
}
