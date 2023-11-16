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

@RestController
@RequestMapping("api/patients")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientServiceImpl;

    @RequestMapping("/create")
   public ResponseEntity<String> savePatient(@RequestBody Patient patient){

       try {
           Optional<Patient> existPatient = patientServiceImpl.findByRegistration(patient.getRegistrationNumber());
           if (existPatient.isPresent()) {
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Patient already exists");
           }
           Patient newPatient = patientServiceImpl.createPatientRecord( patient);
           return ResponseEntity.ok("Patient created successfully with id: " + newPatient.getId());
       } catch (DuplicateKeyException e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration Number already exist");

       } catch (Exception e) {
           // Handle other exceptions
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating Patient: " + e.getMessage());
       }

    }
    @GetMapping
    public ResponseEntity<List<Patient>>getAllPatient(){
        return new ResponseEntity<List<Patient>>(patientServiceImpl.findAllPatient(),HttpStatus.OK);
    }
    @GetMapping("/{registrationNumber}")
    public ResponseEntity<Optional<Patient>>getSinglePatient( @PathVariable String registrationNumber){
        return new ResponseEntity<Optional<Patient>>(patientServiceImpl.findByRegistration(registrationNumber),HttpStatus.OK);
    }

}
