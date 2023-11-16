package com.samju.hospital.repository;

import com.mongodb.client.MongoChangeStreamCursor;
import com.samju.hospital.entity.Radiology;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * The {@code RadiologyRepository} interface serves as a repository for managing {@link Radiology} entities
 * in the hospital management system. It extends the {@link MongoRepository} interface, providing CRUD
 * (Create, Read, Update, Delete) operations for the {@code Radiology} entity.
 *
 * <p>The repository is annotated with {@link Repository} to indicate that it is a Spring Data repository
 * and should be automatically detected and registered in the application context.
 *
 * <p>The repository is designed to work with MongoDB, and it uses {@link Radiology} as the entity type and
 * {@link ObjectId} as the identifier type.
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * public interface SomeService {
 *     RadiologyRepository radiologyRepository;
 *
 *     // Some method that uses the repository
 *     void someMethod() {
 *         List<Radiology> allRadiologies = radiologyRepository.findAll();
 *         // Perform operations with the retrieved radiologies
 *     }
 * }
 * }
 * </pre>
 *
 * @see MongoRepository
 * @see Radiology
 * @see ObjectId
 * @see Repository
 * @version 1.0
 */
@Repository
public interface RadiologyRepository extends MongoRepository<Radiology, ObjectId> {
}

