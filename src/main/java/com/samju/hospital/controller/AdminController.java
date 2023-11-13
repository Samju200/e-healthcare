package com.samju.hospital.controller;

import com.mongodb.DuplicateKeyException;
import com.samju.hospital.entity.AdminUser;
import com.samju.hospital.entity.AdminUserDto;
import com.samju.hospital.service.AdminServiceImpl;
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
public class AdminController {
    @Autowired
    private AdminServiceImpl adminServiceImpl;



    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody AdminUserDto adminUserDto) {
        try {
            Optional <AdminUser>  existUser = adminServiceImpl.usernameCheck(adminUserDto.getUsername());
            if (existUser.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
            }
            AdminUser newUser = adminServiceImpl.createUser(adminUserDto);
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
    public ResponseEntity<?> login(@RequestBody AdminUser loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Optional<AdminUser> userOptional = adminServiceImpl.login(username, password);

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

