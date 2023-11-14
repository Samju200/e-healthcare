package com.samju.hospital.repository;

import com.samju.hospital.entity.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository< Doctor, Long >{
}
