package com.samju.hospital.controller;

import com.samju.hospital.entity.*;
import com.samju.hospital.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    RadiologyService radiologyService;
    @Autowired
    AccountService accountService;
    @PostMapping("/doctors")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Doctor>(doctorService.createDoctorReport(payload.get("fullName"),payload.get("phoneNumber"),
                payload.get("department"), payload.get("reports"), payload.get("registrationNumber")),
        HttpStatus.OK);
    }

    @PostMapping("/nurses")
    public ResponseEntity<Nurse> createNurse(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Nurse>(nurseService.createNurseReport(payload.get("fullName"),payload.get("phoneNumber"),
                payload.get("department"), payload.get("reports"), payload.get("registrationNumber")),
                HttpStatus.OK);
    }
    @PostMapping("/labs")
    public ResponseEntity<Laboratory> createLab(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Laboratory>(laboratoryService.createLabTest(payload.get("fullName"),payload.get("phoneNumber"),
                 payload.get("reports"), payload.get("registrationNumber")),
                HttpStatus.OK);
    }
    @PostMapping("/pharmacy")
    public ResponseEntity<Pharmacy> createPharmacy(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Pharmacy>(pharmacyService.createDrugAdminister(payload.get("fullName"),payload.get("phoneNumber")
                , payload.get("drugs"), payload.get("registrationNumber")),
                HttpStatus.OK);
    }
    @PostMapping("/radiology")
    public ResponseEntity<Radiology> createRadiologyScan(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Radiology>(radiologyService.createScan(payload.get("fullName"),payload.get("phoneNumber"),
                payload.get("images"), payload.get("reports"), payload.get("registrationNumber")),
                HttpStatus.OK);
    }
    @PostMapping("/accounts")
    public ResponseEntity<Account> createBill(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Account>(accountService.createAmount(payload.get("fullName"),payload.get("phoneNumber"),
                 payload.get("amount"), payload.get("registrationNumber")),
                HttpStatus.OK);
    }
}
