package com.samju.hospital.service;

import com.samju.hospital.entity.Patient;
import com.samju.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PatientServiceImpl  implements PatientService{
    @Autowired
    private PatientRepository patientRepository;
    @Override
    public Patient createPatientRecord(Patient patient) {
        Patient newPatient = new Patient();
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

        newPatient.setDoctor(patient.getDoctor());
        newPatient.setNurse(patient.getNurse());
        newPatient.setPharmacy(patient.getPharmacy());
        newPatient.setLaboratory(patient.getLaboratory());
        newPatient.setRadiology(patient.getRadiology());
        newPatient.setAccount(patient.getAccount());
       return patientRepository.save(newPatient);

    }

    @Override
    public Optional<Patient> findByRegistration(String registrationNumber) {
        Optional<Patient> optionalPatient = patientRepository.findByRegistrationNumber(registrationNumber);
        if(optionalPatient.isPresent()){
            Patient patient = optionalPatient.get();
            return Optional.of(patient);
        }
        return Optional.empty();
    }

    @Override
    public List<Patient> findAllPatient() {
        return patientRepository.findAll();
    }

}
