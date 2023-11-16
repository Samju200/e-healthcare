package com.samju.hospital.service;

import com.samju.hospital.entity.Account;
import com.samju.hospital.entity.Patient;
import com.samju.hospital.entity.Pharmacy;
import com.samju.hospital.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The {@code PharmacyService} class provides business logic for managing {@link Pharmacy} entities
 * in the hospital management system. It is annotated with {@link Service} to indicate that it is a
 * Spring service and should be automatically detected and registered in the application context.
 *
 * <p>The service relies on the {@link PharmacyRepository} for basic CRUD operations on pharmacy records.
 * Additionally, it utilizes the {@link MongoTemplate} for more complex MongoDB-specific operations.
 *
 * <p>Methods in this service include:
 * <ul>
 *   <li>{@link #createDrugAdminister(String, String, String, String)}: Create a new pharmacy record
 *   and associate it with a patient.</li>
 * </ul>
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * public class SomeController {
 *     PharmacyService pharmacyService;
 *
 *     // Some method that uses the service
 *     void someMethod() {
 *         Pharmacy newPharmacyRecord = pharmacyService.createDrugAdminister("XYZ Pharmacy", "555-987-1234", "Painkillers", "P123");
 *         // Perform operations with the created pharmacy record
 *     }
 * }
 * }
 * </pre>
 *
 * @see Service
 * @see PharmacyRepository
 * @see MongoTemplate
 * @see Pharmacy
 * @version 1.0
 */
@Service
public class PharmacyService {

    @Autowired
    private PharmacyRepository pharmacyRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Create a new pharmacy record and associate it with a patient identified by the registration number.
     *
     * @param fullName          The full name of the pharmacy administering the drugs.
     * @param phoneNumber       The contact phone number of the pharmacy.
     * @param drugs             The drugs administered by the pharmacy.
     * @param registrationNumber The registration number of the patient to associate the pharmacy record with.
     * @return The created pharmacy record.
     */
    public Pharmacy createDrugAdminister(String fullName, String phoneNumber, String drugs, String registrationNumber) {

        // Create a new pharmacy record
        Pharmacy drugAdminister = new Pharmacy(fullName, phoneNumber, drugs);
        pharmacyRepository.insert(drugAdminister);

        // Update the patient with the newly created pharmacy record
        mongoTemplate.update(Patient.class)
                .matching(Criteria.where("registrationNumber").is(registrationNumber))
                .apply(new Update().push("pharmacy").value(drugAdminister))
                .first();

        return drugAdminister;
    }
    /**
     * Retrieve a list of all pharmacies.
     *
     * @return A {@link List} of {@link Pharmacy} objects representing all pharmacies.
     * @see PharmacyRepository#findAll()
     */
    public List<Pharmacy> findAllPharmacies() {
        return pharmacyRepository.findAll();
    }

}
