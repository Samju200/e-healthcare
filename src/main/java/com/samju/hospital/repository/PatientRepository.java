package com.samju.hospital.repository;

import com.samju.hospital.entity.Patient;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**
 * The {@code PatientRepository} interface serves as a repository for managing {@link Patient} entities
 * in the hospital management system. It extends the {@link MongoRepository} interface, providing CRUD
 * (Create, Read, Update, Delete) operations for the {@code Patient} entity.
 *
 * <p>The repository is annotated with {@link Repository} to indicate that it is a Spring Data repository
 * and should be automatically detected and registered in the application context.
 *
 * <p>The repository is designed to work with MongoDB, and it uses {@link Patient} as the entity type and
 * {@link ObjectId} as the identifier type.
 *
 * <p>Additional methods are provided for custom queries:
 * <ul>
 *   <li>{@link #findByRegistrationNumber(String)}: Find a patient by their registration number.</li>
 *   <li>{@link #findByRegistrationNumber(String, Patient)}: Find a patient by their registration number and parent patient.</li>
 * </ul>
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * public interface SomeService {
 *     PatientRepository patientRepository;
 *
 *     // Some method that uses the repository
 *     void someMethod() {
 *         Optional<Patient> patient = patientRepository.findByRegistrationNumber("123456");
 *         // Perform operations with the retrieved patient
 *     }
 * }
 * }
 * </pre>
 *
 * @see MongoRepository
 * @see Patient
 * @see ObjectId
 * @see Repository
 * @see Optional
 * @see #findByRegistrationNumber(String)
 * @see #findByRegistrationNumber(String, Patient)
 * @version 1.0
 */
@Repository
public interface PatientRepository extends MongoRepository<Patient, ObjectId> {

    /**
     * Find a patient by their registration number.
     *
     * @param registrationNumber The registration number of the patient.
     * @return An optional containing the found patient, or empty if not found.
     */
    Optional<Patient> findByRegistrationNumber(String registrationNumber);

    /**
     * Find a patient by their registration number and parent patient.
     *
     * @param registrationNumber The registration number of the patient.
     * @param parent             The parent patient associated with the search.
     * @return An optional containing the found patient, or empty if not found.
     */
    Optional<Patient> findByRegistrationNumber(String registrationNumber, Patient parent);
}
