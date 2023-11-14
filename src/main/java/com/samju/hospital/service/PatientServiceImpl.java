package com.samju.hospital.service;

import com.samju.hospital.entity.Patient;
import com.samju.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PatientServiceImpl  implements PatientService{
    @Autowired
    private PatientRepository patientRepository;
    @Override
    public Patient createPatientRecord(Patient patient) {
        Patient newPatient = new Patient();
        newPatient.setId(patient.getId());
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
       return patientRepository.save(newPatient);

    }
}