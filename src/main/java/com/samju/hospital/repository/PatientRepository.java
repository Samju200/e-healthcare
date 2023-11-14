package com.samju.hospital.repository;

import com.samju.hospital.entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, Long > {
}
