package com.samju.hospital.service;

import com.samju.hospital.entity.Patient;
import com.samju.hospital.entity.User;

import java.util.Optional;

public interface PatientService {
    Patient createPatientRecord(Patient patient);
    Optional<Patient> findByRegistration(String registrationNumber);
}
