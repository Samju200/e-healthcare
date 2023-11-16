package com.samju.hospital.repository;

import com.samju.hospital.entity.Nurse;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/**
 * The {@code NurseRepository} interface serves as a repository for managing {@link Nurse} entities
 * in the hospital management system. It extends the {@link MongoRepository} interface, providing CRUD
 * (Create, Read, Update, Delete) operations for the {@code Nurse} entity.
 *
 * <p>The repository is annotated with {@link Repository} to indicate that it is a Spring Data repository
 * and should be automatically detected and registered in the application context.
 *
 * <p>The repository is designed to work with MongoDB, and it uses {@link Nurse} as the entity type and
 * {@link ObjectId} as the identifier type.
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * public interface SomeService {
 *     NurseRepository nurseRepository;
 *
 *     // Some method that uses the repository
 *     void someMethod() {
 *         List<Nurse> allNurses = nurseRepository.findAll();
 *         // Perform operations with the retrieved nurses
 *     }
 * }
 * }
 * </pre>
 *
 * @see MongoRepository
 * @see Nurse
 * @see ObjectId
 * @see Repository
 * @author Juwon Adeyemi
 * @version 1.0
 */
@Repository
public interface NurseRepository extends MongoRepository<Nurse, ObjectId> {
}

