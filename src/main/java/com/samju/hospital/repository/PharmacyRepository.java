package com.samju.hospital.repository;

import com.samju.hospital.entity.Laboratory;
import com.samju.hospital.entity.Pharmacy;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PharmacyRepository extends MongoRepository<Pharmacy, Long> {
}
