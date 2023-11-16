package com.samju.hospital.service;

import com.samju.hospital.entity.Patient;
import com.samju.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * The {@code PatientServiceImpl} class implements the {@link PatientService} interface
 * and provides the implementation for managing {@link Patient} entities in the hospital management system.
 * It is annotated with {@link Service} to indicate that it is a Spring service and should be
 * automatically detected and registered in the application context.
 *
 * <p>Methods in this implementation include:
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
 * @see PatientService
 * @see PatientRepository
 * @see Service
 * @version 1.0
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    /**
     * Create a new patient record.
     *
     * @param patient The patient entity to be created.
     * @return The created patient entity.
     */
    @Override
    public Patient createPatientRecord(Patient patient) {
        Patient newPatient = new Patient();
        newPatient.setRegistrationType(patient.getRegistrationType());
        newPatient.setHmoType(patient.getHmoType());
        newPatient.setRegistrationNumber(patient.getRegistrationNumber());
        newPatient.setPatientStatus(patient.getPatientStatus());
        newPatient.setTitle(patient.getTitle());
        newPatient.setSurname(patient.getSurname());
        newPatient.setFirstname(patient.getFirstname());
        newPatient.setPhoneNumber(patient.getPhoneNumber());
        newPatient.setAddress(patient.getAddress());
        newPatient.setDateOfBirth(patient.getDateOfBirth());
        newPatient.setAge(patient.getAge());
        newPatient.setNextOfKinName(patient.getNextOfKinName());
        newPatient.setNextOfKinAddress(patient.getNextOfKinAddress());
        newPatient.setNextOfKinPhoneNumber(patient.getNextOfKinPhoneNumber());

        newPatient.setDoctors(patient.getDoctors());
        newPatient.setNurses(patient.getNurses());
        newPatient.setPharmacies(patient.getPharmacies());
        newPatient.setLaboratories(patient.getLaboratories());
        newPatient.setRadiologys(patient.getRadiologys());
        newPatient.setAccounts(patient.getAccounts());

        return patientRepository.save(newPatient);
    }

    /**
     * Find a patient by their registration number.
     *
     * @param registrationNumber The registration number of the patient.
     * @return An optional containing the found patient, or empty if not found.
     */
    @Override
    public Optional<Patient> findByRegistration(String registrationNumber) {
        return patientRepository.findByRegistrationNumber(registrationNumber);
    }

    /**
     * Retrieve a list of all patients.
     *
     * @return A list of all patients in the system.
     */
    @Override
    public List<Patient> findAllPatient() {
        return patientRepository.findAll();
    }
}
