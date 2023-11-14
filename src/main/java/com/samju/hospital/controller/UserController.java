package com.samju.hospital.controller;

import com.mongodb.DuplicateKeyException;
import com.samju.hospital.entity.User;
import com.samju.hospital.entity.UserDto;
import com.samju.hospital.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserServiceImpl adminServiceImpl;



    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        try {
            Optional <User>  existUser = adminServiceImpl.usernameCheck(userDto.getUsername());
            if (existUser.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
            }
            User newUser = adminServiceImpl.createUser(userDto);
            // You may want to return only specific information or a success message
            return ResponseEntity.ok("User created successfully with id: " + newUser.getId());
        } catch (DuplicateKeyException e) {
            // Handle duplicate username exception
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");

        } catch (Exception e) {
            // Handle other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Optional<User> userOptional = adminServiceImpl.login(username, password);

        if (userOptional.isPresent()) {
            // User authenticated successfully
            // You may generate a JWT token here and return it in the response
            return ResponseEntity.ok("Login successful");
        } else {
            // Authentication failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}

