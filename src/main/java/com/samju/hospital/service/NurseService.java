package com.samju.hospital.service;

import com.samju.hospital.entity.Account;
import com.samju.hospital.entity.Doctor;
import com.samju.hospital.entity.Nurse;
import com.samju.hospital.entity.Patient;
import com.samju.hospital.repository.DoctorRepository;
import com.samju.hospital.repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The {@code NurseService} class provides business logic for managing {@link Nurse} entities
 * in the hospital management system. It is annotated with {@link Service} to indicate that it is a
 * Spring service and should be automatically detected and registered in the application context.
 *
 * <p>The service relies on the {@link NurseRepository} for basic CRUD operations on nurses.
 * Additionally, it utilizes the {@link MongoTemplate} for more complex MongoDB-specific operations.
 *
 * <p>Methods in this service include:
 * <ul>
 *   <li>{@link #createNurseReport(String, String, String, String, String)}: Create a new nurse report
 *   and associate it with a patient.</li>
 * </ul>
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * public class SomeController {
 *     NurseService nurseService;
 *
 *     // Some method that uses the service
 *     void someMethod() {
 *         Nurse newNurseReport = nurseService.createNurseReport("Nurse Johnson", "123-555-7890", "Pediatrics", "Patient Monitoring", "P456");
 *         // Perform operations with the created nurse report
 *     }
 * }
 * }
 * </pre>
 *
 * @see Service
 * @see NurseRepository
 * @see MongoTemplate
 * @see Nurse
 * @version 1.0
 */
@Service
public class NurseService {

    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Create a new nurse report and associate it with a patient identified by the registration number.
     *
     * @param fullName          The full name of the nurse.
     * @param phoneNumber       The contact phone number of the nurse.
     * @param department        The department the nurse belongs to.
     * @param reports           The medical reports or notes provided by the nurse.
     * @param registrationNumber The registration number of the patient to associate the nurse report with.
     * @return The created nurse report.
     */
    public Nurse createNurseReport(String fullName, String phoneNumber, String department, String reports, String registrationNumber) {

        // Create a new nurse report
        Nurse nurseReport = new Nurse(fullName, phoneNumber, department, reports);
        nurseRepository.insert(nurseReport);

        // Update the patient with the newly created nurse report
        mongoTemplate.update(Patient.class)
                .matching(Criteria.where("registrationNumber").is(registrationNumber))
                .apply(new Update().push("nurse").value(nurseReport))
                .first();

        return nurseReport;
    }
    /**
     * Retrieve a list of all nurses.
     *
     * @return A {@link List} of {@link Nurse} objects representing all nurses.
     * @see NurseRepository#findAll()
     */
    public List<Nurse> findAllNurses() {
        return nurseRepository.findAll();
    }

}
