package com.samju.hospital.service;


import com.samju.hospital.entity.Laboratory;
import com.samju.hospital.entity.Patient;
import com.samju.hospital.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * The {@code LaboratoryService} class provides business logic for managing {@link Laboratory} entities
 * in the hospital management system. It is annotated with {@link Service} to indicate that it is a
 * Spring service and should be automatically detected and registered in the application context.
 *
 * <p>The service relies on the {@link LaboratoryRepository} for basic CRUD operations on laboratory tests.
 * Additionally, it utilizes the {@link MongoTemplate} for more complex MongoDB-specific operations.
 *
 * <p>Methods in this service include:
 * <ul>
 *   <li>{@link #createLabTest(String, String, String, String)}: Create a new laboratory test
 *   and associate it with a patient.</li>
 * </ul>
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * public class SomeController {
 *     LaboratoryService laboratoryService;
 *
 *     // Some method that uses the service
 *     void someMethod() {
 *         Laboratory newLabTest = laboratoryService.createLabTest("LabCorp", "555-123-4567", "Blood Test Results", "P789");
 *         // Perform operations with the created laboratory test
 *     }
 * }
 * }
 * </pre>
 *
 * @see Service
 * @see LaboratoryRepository
 * @see MongoTemplate
 * @see Laboratory
 * @version 1.0
 */
@Service
public class LaboratoryService {

    @Autowired
    private LaboratoryRepository laboratoryRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Create a new laboratory test and associate it with a patient identified by the registration number.
     *
     * @param fullName          The full name of the laboratory conducting the test.
     * @param phoneNumber       The contact phone number of the laboratory.
     * @param labReports        The test reports or results provided by the laboratory.
     * @param registrationNumber The registration number of the patient to associate the laboratory test with.
     * @return The created laboratory test.
     */
    public Laboratory createLabTest(String fullName, String phoneNumber, String labReports, String registrationNumber) {

        // Create a new laboratory test
        Laboratory labTest = new Laboratory(fullName, phoneNumber, labReports);
        laboratoryRepository.insert(labTest);

        // Update the patient with the newly created laboratory test
        mongoTemplate.update(Patient.class)
                .matching(Criteria.where("registrationNumber").is(registrationNumber))
                .apply(new Update().push("laboratories").value(labTest))
                .first();

        return labTest;
    }
}
