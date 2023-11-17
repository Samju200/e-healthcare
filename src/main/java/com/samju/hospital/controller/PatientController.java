package com.samju.hospital.controller;

import com.mongodb.DuplicateKeyException;
import com.samju.hospital.entity.Patient;
import com.samju.hospital.service.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The {@code PatientController} class defines RESTful endpoints for managing patient records
 * in the hospital management system. It is annotated with {@link RestController} to indicate that
 * it is a Spring MVC controller for handling HTTP requests.
 *
 * <p>Endpoints in this controller include:
 * <ul>
 *   <li>{@code /api/patients/create}: Create a new patient record.</li>
 *   <li>{@code /api/patients}: Get all patient records.</li>
 *   <li>{@code /api/patients/{registrationNumber}}: Get a single patient record by registration number.</li>
 * </ul>
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * public class SomeClient {
 *     // Example usage of the RESTful endpoints provided by PatientController
 * }
 * }
 * </pre>
 *
 * @see RestController
 * @see ResponseEntity
 * @see PatientServiceImpl
 * @see Patient
 * @version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("api/patients")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientServiceImpl;

    /**
     * Create a new patient record.
     *
     * @param patient The {@link Patient} object containing information for creating a patient record.
     * @return A {@link ResponseEntity} with a status code and a message indicating the result of the operation.
     */
    @RequestMapping("/create")
    public ResponseEntity<String> savePatient(@RequestBody Patient patient) {

        try {
            Optional<Patient> existPatient = patientServiceImpl.findByRegistration(patient.getRegistrationNumber());
            if (existPatient.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Patient already exists");
            }
            Patient newPatient = patientServiceImpl.createPatientRecord(patient);
            return ResponseEntity.ok("Patient created successfully with id: " + newPatient.getId());
        } catch (DuplicateKeyException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration Number already exists");

        } catch (Exception e) {
            // Handle other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating Patient: " + e.getMessage());
        }
    }

    /**
     * Get all patient records.
     *
     * @return A {@link ResponseEntity} containing a list of {@link Patient} entities and an HTTP status.
     */
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatient() {
        return new ResponseEntity<>(patientServiceImpl.findAllPatient(), HttpStatus.OK);
    }

    /**
     * Get a single patient record by registration number.
     *
     * @param registrationNumber The registration number of the patient to retrieve.
     * @return A {@link ResponseEntity} containing an {@link Optional} of {@link Patient} and an HTTP status.
     */
    @GetMapping("/{registrationNumber}")
    public ResponseEntity<Optional<Patient>> getSinglePatient(@PathVariable String registrationNumber) {
        return new ResponseEntity<>(patientServiceImpl.findByRegistration(registrationNumber), HttpStatus.OK);
    }
}
