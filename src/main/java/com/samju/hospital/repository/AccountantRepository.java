package com.samju.hospital.repository;

import com.samju.hospital.entity.Accountant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountantRepository extends MongoRepository<Accountant, Long> {
}
