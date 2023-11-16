package com.samju.hospital.service;

import com.samju.hospital.entity.Doctor;
import com.samju.hospital.entity.Patient;
import com.samju.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * The {@code DoctorService} class provides business logic for managing {@link Doctor} entities
 * in the hospital management system. It is annotated with {@link Service} to indicate that it is a
 * Spring service and should be automatically detected and registered in the application context.
 *
 * <p>The service relies on the {@link DoctorRepository} for basic CRUD operations on doctors.
 * Additionally, it utilizes the {@link MongoTemplate} for more complex MongoDB-specific operations.
 *
 * <p>Methods in this service include:
 * <ul>
 *   <li>{@link #createDoctorReport(String, String, String, String, String)}: Create a new doctor report
 *   and associate it with a patient.</li>
 * </ul>
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * public class SomeController {
 *     DoctorService doctorService;
 *
 *     // Some method that uses the service
 *     void someMethod() {
 *         Doctor newDoctorReport = doctorService.createDoctorReport("Dr. Smith", "987-654-3210", "Cardiology", "Patient Report", "P456");
 *         // Perform operations with the created doctor report
 *     }
 * }
 * }
 * </pre>
 *
 * @see Service
 * @see DoctorRepository
 * @see MongoTemplate
 * @see Doctor
 * @version 1.0
 */
@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Create a new doctor report and associate it with a patient identified by the registration number.
     *
     * @param fullName          The full name of the doctor.
     * @param phoneNumber       The contact phone number of the doctor.
     * @param department        The department the doctor belongs to.
     * @param reports           The medical reports or notes provided by the doctor.
     * @param registrationNumber The registration number of the patient to associate the doctor report with.
     * @return The created doctor report.
     */
    public Doctor createDoctorReport(String fullName, String phoneNumber, String department, String reports, String registrationNumber) {

        // Create a new doctor report
        Doctor doctorReport = new Doctor(fullName, phoneNumber, department, reports);
        doctorRepository.insert(doctorReport);

        // Update the patient with the newly created doctor report
        mongoTemplate.update(Patient.class)
                .matching(Criteria.where("registrationNumber").is(registrationNumber))
                .apply(new Update().push("doctor").value(doctorReport))
                .first();

        return doctorReport;
    }
}
