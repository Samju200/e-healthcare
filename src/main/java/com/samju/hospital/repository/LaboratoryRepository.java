package com.samju.hospital.repository;

import com.samju.hospital.entity.Doctor;
import com.samju.hospital.entity.Laboratory;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * The {@code LaboratoryRepository} interface serves as a repository for managing {@link Laboratory} entities
 * in the hospital management system. It extends the {@link MongoRepository} interface, providing CRUD
 * (Create, Read, Update, Delete) operations for the {@code Laboratory} entity.
 *
 * <p>The repository is annotated with {@link Repository} to indicate that it is a Spring Data repository
 * and should be automatically detected and registered in the application context.
 *
 * <p>The repository is designed to work with MongoDB, and it uses {@link Laboratory} as the entity type and
 * {@link ObjectId} as the identifier type.
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * public interface SomeService {
 *     LaboratoryRepository laboratoryRepository;
 *
 *     // Some method that uses the repository
 *     void someMethod() {
 *         List<Laboratory> allLaboratories = LaboratoryRepository.findAll();
 *         // Perform operations with the retrieved doctors
 *     }
 * }
 * }
 * </pre>
 *
 * @see MongoRepository
 * @see Laboratory
 * @see ObjectId
 * @see Repository
 * @author Juwon Adeyemi
 * @version 1.0
 */
@Repository
public interface LaboratoryRepository extends MongoRepository<Laboratory, ObjectId> {
}
