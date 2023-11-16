package com.samju.hospital.service;

import com.samju.hospital.entity.Patient;
import com.samju.hospital.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * The {@code PatientService} interface defines the contract for managing {@link Patient} entities
 * in the hospital management system.
 *
 * <p>Methods in this interface include:
 * <ul>
 *   <li>{@link #createPatientRecord(Patient)}: Create a new patient record.</li>
 *   <li>{@link #findByRegistration(String)}: Find a patient by their registration number.</li>
 *   <li>{@link #findAllPatient()}: Retrieve a list of all patients.</li>
 * </ul>
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * public class SomeController {
 *     PatientService patientService;
 *
 *     // Some method that uses the service
 *     void someMethod() {
 *         Patient newPatient = // Create a new patient instance
 *         Patient createdPatient = patientService.createPatientRecord(newPatient);
 *         // Perform operations with the created patient record
 *     }
 * }
 * }
 * </pre>
 *
 * @see Patient
 * @version 1.0
 */
public interface PatientService {

    /**
     * Create a new patient record.
     *
     * @param patient The patient entity to be created.
     * @return The created patient entity.
     */
    Patient createPatientRecord(Patient patient);

    /**
     * Find a patient by their registration number.
     *
     * @param registrationNumber The registration number of the patient.
     * @return An optional containing the found patient, or empty if not found.
     */
    Optional<Patient> findByRegistration(String registrationNumber);

    /**
     * Retrieve a list of all patients.
     *
     * @return A list of all patients in the system.
     */
    List<Patient> findAllPatient();
}

