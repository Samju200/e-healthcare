package com.samju.hospital.service;

import com.samju.hospital.entity.User;
import com.samju.hospital.entity.UserDto;
import com.samju.hospital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import com.samju.hospital.config.SecurityConfig.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The {@code UserServiceImpl} class implements the {@link UserService} interface
 * and provides the implementation for managing {@link User} entities in the hospital management system.
 * It is annotated with {@link Service} to indicate that it is a Spring service and should be
 * automatically detected and registered in the application context.
 *
 * <p>The service relies on the {@link UserRepository} for basic CRUD operations on user records.
 *
 * <p>Methods in this implementation include:
 * <ul>
 *   <li>{@link #createUser(UserDto)}: Create a new user.</li>
 *   <li>{@link #login(String, String)}: Authenticate a user based on username and password.</li>
 *   <li>{@link #usernameCheck(String)}: Check if a username is already in use.</li>
 * </ul>
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * public class SomeController {
 *     UserService userService;
 *
 *     // Some method that uses the service
 *     void someMethod() {
 *         UserDto newUserDto = // Create a new user DTO
 *         User createdUser = userService.createUser(newUserDto);
 *         // Perform operations with the created user
 *     }
 * }
 * }
 * </pre>
 *
 * @see UserService
 * @see User
 * @see UserDto
 * @see UserRepository
 * @see Service
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Create a new user.
     *
     * @param userDto The user data transfer object containing user information.
     * @return The created user entity.
     */
    @Override
    public User createUser(UserDto userDto) {
        User newUser = new User();
        newUser.setUsername(userDto.getUsername());
        newUser.setFullName(userDto.getFullName());
        newUser.setPassword(userDto.getPassword());
        newUser.setPhoneNumber(userDto.getPhoneNumber());
        newUser.setRole(userDto.getRole());
        return userRepository.save(newUser);
    }

    /**
     * Authenticate a user based on username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return An optional containing the authenticated user, or empty if authentication fails.
     */
    @Override
    public User login(String username, String password) {

        return userRepository.findByUsernameAndPassword(username, password);
    }

    /**
     * Check if a username is already in use.
     *
     * @param username The username to check.
     * @return An optional containing the user with the specified username if it exists, or empty if not.
     */
    @Override
    public Optional<User> usernameCheck(String username) {
        return userRepository.findByUsername(username);
    }
}
