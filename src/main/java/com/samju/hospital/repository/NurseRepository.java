package com.samju.hospital.repository;

import com.samju.hospital.entity.Nurse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NurseRepository extends MongoRepository<Nurse, Long> {
}
