package com.samju.hospital.service;

import com.samju.hospital.entity.Patient;
import com.samju.hospital.entity.Radiology;

import com.samju.hospital.repository.RadiologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * The {@code RadiologyService} class provides business logic for managing {@link Radiology} entities
 * in the hospital management system. It is annotated with {@link Service} to indicate that it is a
 * Spring service and should be automatically detected and registered in the application context.
 *
 * <p>The service relies on the {@link RadiologyRepository} for basic CRUD operations on radiology records.
 * Additionally, it utilizes the {@link MongoTemplate} for more complex MongoDB-specific operations.
 *
 * <p>Methods in this service include:
 * <ul>
 *   <li>{@link #createScan(String, String, String, String, String)}: Create a new radiology record
 *   and associate it with a patient.</li>
 * </ul>
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * public class SomeController {
 *     RadiologyService radiologyService;
 *
 *     // Some method that uses the service
 *     void someMethod() {
 *         Radiology newScanResult = radiologyService.createScan("Imaging Center", "555-123-4567", "X-ray Images", "Detailed Report", "P789");
 *         // Perform operations with the created radiology record
 *     }
 * }
 * }
 * </pre>
 *
 * @see Service
 * @see RadiologyRepository
 * @see MongoTemplate
 * @see Radiology
 * @version 1.0
 */
@Service
public class RadiologyService {

    @Autowired
    private RadiologyRepository radiologyRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Create a new radiology record and associate it with a patient identified by the registration number.
     *
     * @param fullName          The full name of the radiology center conducting the scan.
     * @param phoneNumber       The contact phone number of the radiology center.
     * @param images            The images produced by the radiology scan.
     * @param reports           The detailed reports or findings from the radiology scan.
     * @param registrationNumber The registration number of the patient to associate the radiology record with.
     * @return The created radiology record.
     */
    public Radiology createScan(String fullName, String phoneNumber, String images, String reports, String registrationNumber) {

        // Create a new radiology record
        Radiology scannerResults = new Radiology(fullName, phoneNumber, images, reports);
        radiologyRepository.insert(scannerResults);

        // Update the patient with the newly created radiology record
        mongoTemplate.update(Patient.class)
                .matching(Criteria.where("registrationNumber").is(registrationNumber))
                .apply(new Update().push("radiologys").value(scannerResults))
                .first();

        return scannerResults;
    }
}
