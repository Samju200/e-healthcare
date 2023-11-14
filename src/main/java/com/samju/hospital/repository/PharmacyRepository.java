package com.samju.hospital.repository;

import com.samju.hospital.entity.Laboratory;
import com.samju.hospital.entity.Pharmacy;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyRepository extends MongoRepository<Pharmacy, ObjectId> {
}
