package com.samju.hospital.repository;

import com.samju.hospital.entity.Laboratory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LaboratoryRepository extends MongoRepository<Laboratory, Long> {
}
