package com.samju.hospital.service;
import com.samju.hospital.entity.User;
import com.samju.hospital.entity.UserDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

/**
 * The {@code UserService} interface defines the contract for managing {@link User} entities
 * in the hospital management system.
 *
 * <p>Methods in this interface include:
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
 * @see User
 * @see UserDto
 * @version 1.0
 */
public interface UserService {

    /**
     * Create a new user.
     *
     * @param userDto The user data transfer object containing user information.
     * @return The created user entity.
     */
    User createUser(String username,
                    String fullName,
                    String password,
                    String phoneNumber,
                    String role, MultipartFile file)throws IOException;

    /**
     * Authenticate a user based on username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return An optional containing the authenticated user, or empty if authentication fails.
     */
    User login(String username, String password);

    /**
     * Check if a username is already in use.
     *
     * @param username The username to check.
     * @return An optional containing the user with the specified username if it exists, or empty if not.
     */
    Optional<User> usernameCheck(String username);
}

