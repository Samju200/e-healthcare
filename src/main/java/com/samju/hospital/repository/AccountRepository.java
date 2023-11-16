package com.samju.hospital.repository;

import com.samju.hospital.entity.Account;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/**
 * The {@code AccountRepository} interface serves as a repository for managing {@link Account} entities
 * in the hospital management system. It extends the {@link MongoRepository} interface, providing CRUD
 * (Create, Read, Update, Delete) operations for the {@code Account} entity.
 *
 * <p>The repository is annotated with {@link Repository} to indicate that it is a Spring Data repository
 * and should be automatically detected and registered in the application context.
 *
 * <p>The repository is designed to work with MongoDB, and it uses {@link Account} as the entity type and
 * {@link ObjectId} as the identifier type.
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * public interface SomeService {
 *     AccountRepository accountRepository;
 *
 *     // Some method that uses the repository
 *     void someMethod() {
 *         List<Account> allAccounts = accountRepository.findAll();
 *         // Perform operations with the retrieved accounts
 *     }
 * }
 * }
 * </pre>
 *
 * @see MongoRepository
 * @see Account
 * @see ObjectId
 * @see Repository
 * @author Juwon Adeyemi
 * @version 1.0
 */
@Repository
public interface AccountRepository extends MongoRepository<Account, ObjectId> {
}

