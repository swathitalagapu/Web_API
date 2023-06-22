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

    public User updateUserDetails(long id, User user) {
    User usr = userRepository.findById(user.getId()).orElse(null);
        usr.setUserId(user.getUserId());
        usr.setTitle(user.getTitle());
        usr.setBody(user.getBody());
        User updatedUser = userRepository.save(usr);
        return updatedUser;
    }

    public void deleteUserDetails(long id){
        userRepository.deleteById(id);
    }
}
