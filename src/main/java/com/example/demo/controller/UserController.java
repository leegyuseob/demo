package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public void userCreate() {
        User build = User.builder()
                .account("userAcount")
                .email("mrt@myrealtrip.com")
                .phoneNumber("010-1233-0222")
                .createdAt(LocalDateTime.now())
                .createdBy("admin")
                .build();

        userRepository.save(build);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);

        return new ResponseEntity(user, HttpStatus.OK);
    }

}
