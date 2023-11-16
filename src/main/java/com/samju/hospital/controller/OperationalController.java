package com.samju.hospital.controller;

import com.samju.hospital.entity.*;
import com.samju.hospital.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * The {@code OperationalController} class defines RESTful endpoints for creating operational records
 * in the hospital management system. It is annotated with {@link RestController} to indicate that
 * it is a Spring MVC controller for handling HTTP requests.
 *
 * <p>Endpoints in this controller include:
 * <ul>
 *   <li>{@code /api/doctor}: Create a new doctor report.</li>
 *   <li>{@code /api/nurse}: Create a new nurse report.</li>
 *   <li>{@code /api/lab}: Create a new laboratory test.</li>
 *   <li>{@code /api/pharmacy}: Create a new pharmacy record for drug administration.</li>
 *   <li>{@code /api/radiology}: Create a new radiology scan.</li>
 *   <li>{@code /api/account}: Create a new account record for billing.</li>
 * </ul>
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * public class SomeClient {
 *     // Example usage of the RESTful endpoints provided by OperationalController
 * }
 * }
 * </pre>
 *
 * @see RestController
 * @see ResponseEntity
 * @see Map
 * @see DoctorService
 * @see NurseService
 * @see LaboratoryService
 * @see PharmacyService
 * @see RadiologyService
 * @see AccountService
 * @version 1.0
 */
@RestController
@RequestMapping("/api")
public class OperationalController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private NurseService nurseService;
    @Autowired
    private LaboratoryService laboratoryService;
    @Autowired
    private PharmacyService pharmacyService;
    @Autowired
    private RadiologyService radiologyService;
    @Autowired
    private AccountService accountService;

    /**
     * Create a new doctor report.
     *
     * @param payload The request payload containing information for creating a doctor report.
     * @return A {@link ResponseEntity} containing the created {@link Doctor} entity and an HTTP status.
     */
    @PostMapping("/doctor")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(doctorService.createDoctorReport(
                payload.get("fullName"),
                payload.get("phoneNumber"),
                payload.get("department"),
                payload.get("reports"),
                payload.get("registrationNumber")),
                HttpStatus.OK);
    }

    /**
     * Create a new nurse report.
     *
     * @param payload The request payload containing information for creating a nurse report.
     * @return A {@link ResponseEntity} containing the created {@link Nurse} entity and an HTTP status.
     */
    @PostMapping("/nurse")
    public ResponseEntity<Nurse> createNurse(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(nurseService.createNurseReport(
                payload.get("fullName"),
                payload.get("phoneNumber"),
                payload.get("department"),
                payload.get("reports"),
                payload.get("registrationNumber")),
                HttpStatus.OK);
    }

    /**
     * Create a new laboratory test.
     *
     * @param payload The request payload containing information for creating a laboratory test.
     * @return A {@link ResponseEntity} containing the created {@link Laboratory} entity and an HTTP status.
     */
    @PostMapping("/lab")
    public ResponseEntity<Laboratory> createLab(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(laboratoryService.createLabTest(
                payload.get("fullName"),
                payload.get("phoneNumber"),
                payload.get("reports"),
                payload.get("registrationNumber")),
                HttpStatus.OK);
    }

    /**
     * Create a new pharmacy record for drug administration.
     *
     * @param payload The request payload containing information for creating a pharmacy record.
     * @return A {@link ResponseEntity} containing the created {@link Pharmacy} entity and an HTTP status.
     */
    @PostMapping("/pharmacy")
    public ResponseEntity<Pharmacy> createPharmacy(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(pharmacyService.createDrugAdminister(
                payload.get("fullName"),
                payload.get("phoneNumber"),
                payload.get("drugs"),
                payload.get("registrationNumber")),
                HttpStatus.OK);
    }

    /**
     * Create a new radiology scan.
     *
     * @param payload The request payload containing information for creating a radiology scan.
     * @return A {@link ResponseEntity} containing the created {@link Radiology} entity and an HTTP status.
     */
    @PostMapping("/radiology")
    public ResponseEntity<Radiology> createRadiologyScan(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(radiologyService.createScan(
                payload.get("fullName"),
                payload.get("phoneNumber"),
                payload.get("images"),
                payload.get("reports"),
                payload.get("registrationNumber")),
                HttpStatus.OK);
    }

    /**
     * Create a new account record for billing.
     *
     * @param payload The request payload containing information for creating an account record.
     * @return A {@link ResponseEntity} containing the created {@link Account} entity and an HTTP status.
     */
    @PostMapping("/account")
    public ResponseEntity<Account> createBill(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(accountService.createAmount(
                payload.get("fullName"),
                payload.get("phoneNumber"),
                payload.get("amount"),
                payload.get("registrationNumber")),
                HttpStatus.OK);
    }
}
