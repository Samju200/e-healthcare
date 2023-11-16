package com.samju.hospital.repository;

import com.samju.hospital.entity.Laboratory;
import com.samju.hospital.entity.Pharmacy;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * The {@code PharmacyRepository} interface serves as a repository for managing {@link Pharmacy} entities
 * in the hospital management system. It extends the {@link MongoRepository} interface, providing CRUD
 * (Create, Read, Update, Delete) operations for the {@code Pharmacy} entity.
 *
 * <p>The repository is annotated with {@link Repository} to indicate that it is a Spring Data repository
 * and should be automatically detected and registered in the application context.
 *
 * <p>The repository is designed to work with MongoDB, and it uses {@link Pharmacy} as the entity type and
 * {@link ObjectId} as the identifier type.
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * public interface SomeService {
 *     PharmacyRepository pharmacyRepository;
 *
 *     // Some method that uses the repository
 *     void someMethod() {
 *         List<Pharmacy> allPharmacies = pharmacyRepository.findAll();
 *         // Perform operations with the retrieved pharmacies
 *     }
 * }
 * }
 * </pre>
 *
 * @see MongoRepository
 * @see Pharmacy
 * @see ObjectId
 * @see Repository
 * @version 1.0
 */
@Repository
public interface PharmacyRepository extends MongoRepository<Pharmacy, ObjectId> {
}

