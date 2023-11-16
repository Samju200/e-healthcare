package com.samju.hospital.repository;

import com.samju.hospital.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**
 * The {@code UserRepository} interface serves as a repository for managing {@link User} entities
 * in the hospital management system. It extends the {@link MongoRepository} interface, providing CRUD
 * (Create, Read, Update, Delete) operations for the {@code User} entity.
 *
 * <p>The repository is annotated with {@link Repository} to indicate that it is a Spring Data repository
 * and should be automatically detected and registered in the application context.
 *
 * <p>The repository is designed to work with MongoDB, and it uses {@link User} as the entity type and
 * {@link ObjectId} as the identifier type.
 *
 * <p>Additional methods are provided for custom queries:
 * <ul>
 *   <li>{@link #findByUsername(String)}: Find a user by their username.</li>
 * </ul>
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * public interface SomeService {
 *     UserRepository userRepository;
 *
 *     // Some method that uses the repository
 *     void someMethod() {
 *         Optional<User> user = userRepository.findByUsername("john_doe");
 *         // Perform operations with the retrieved user
 *     }
 * }
 * }
 * </pre>
 *
 * @see MongoRepository
 * @see User
 * @see ObjectId
 * @see Repository
 * @see Optional
 * @see #findByUsername(String)
 * @version 1.0
 */
@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    /**
     * Find a user by their username.
     *
     * @param username The username of the user.
     * @return An optional containing the found user, or empty if not found.
     */
    Optional<User> findByUsername(String username);
}
