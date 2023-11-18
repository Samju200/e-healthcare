package com.samju.hospital.controller;

import com.mongodb.DuplicateKeyException;
import com.samju.hospital.entity.User;
import com.samju.hospital.entity.UserDto;
import com.samju.hospital.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * The {@code UserController} class defines RESTful endpoints for user-related operations in
 * the hospital management system. It is annotated with {@link RestController} to indicate that
 * it is a Spring MVC controller for handling HTTP requests.
 *
 * <p>Endpoints in this controller include:
 * <ul>
 *   <li>{@code /api/users/create}: Create a new user.</li>
 *   <li>{@code /api/users/login}: Perform user login.</li>
 * </ul>
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * public class SomeClient {
 *     // Example usage of the RESTful endpoints provided by UserController
 * }
 * }
 * </pre>
 *
 * @see RestController
 * @see ResponseEntity
 * @see UserDto
 * @see User
 * @see UserServiceImpl
 * @version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * Create a new user.
     *
     * @param userDto The {@link UserDto} object containing information for creating a new user.
     * @return A {@link ResponseEntity} with a status code and a message indicating the result of the operation.
     */
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        try {
            Optional<User> existUser = userServiceImpl.usernameCheck(userDto.getUsername());
            if (existUser.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
            }
            User newUser = userServiceImpl.createUser(userDto);
            // You may want to return only specific information or a success message
            return new ResponseEntity<>(newUser, HttpStatus.OK);
        } catch (DuplicateKeyException e) {
            // Handle duplicate username exception
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");

        } catch (Exception e) {
            // Handle other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user: " + e.getMessage());
        }
    }

    /**
     * Perform user login.
     *
     * @param loginRequest The {@link User} object containing the username and password for authentication.
     * @return A {@link ResponseEntity} with a status code and a message indicating the result of the login attempt.
     */
    @PostMapping("/login")
    public User login(@RequestBody User loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        return userServiceImpl.login(username, password);


    }
}