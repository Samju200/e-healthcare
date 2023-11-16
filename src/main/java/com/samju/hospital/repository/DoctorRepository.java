package com.samju.hospital.repository;

import com.samju.hospital.entity.Doctor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * The {@code DoctorRepository} interface serves as a repository for managing {@link Doctor} entities
 * in the hospital management system. It extends the {@link MongoRepository} interface, providing CRUD
 * (Create, Read, Update, Delete) operations for the {@code Doctor} entity.
 *
 * <p>The repository is annotated with {@link Repository} to indicate that it is a Spring Data repository
 * and should be automatically detected and registered in the application context.
 *
 * <p>The repository is designed to work with MongoDB, and it uses {@link Doctor} as the entity type and
 * {@link ObjectId} as the identifier type.
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * public interface SomeService {
 *     DoctorRepository doctorRepository;
 *
 *     // Some method that uses the repository
 *     void someMethod() {
 *         List<Doctor> allDoctors = doctorRepository.findAll();
 *         // Perform operations with the retrieved doctors
 *     }
 * }
 * }
 * </pre>
 *
 * @see MongoRepository
 * @see Doctor
 * @see ObjectId
 * @see Repository
 * @author Juwon Adeyemi
 * @version 1.0
 */
@Repository
public interface DoctorRepository extends MongoRepository<Doctor, ObjectId> {
}
