package com.samju.hospital.repository;

import com.samju.hospital.entity.Doctor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends MongoRepository< Doctor, ObjectId>{
}
