package com.samju.hospital.repository;

import com.samju.hospital.entity.Patient;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PatientRepository extends MongoRepository<Patient, ObjectId> {
    Optional<Patient> findByRegistrationNumber(String registrationNumber);
    Optional<Patient> findByRegistrationNumber(String registrationNumber, Patient parent);
}
