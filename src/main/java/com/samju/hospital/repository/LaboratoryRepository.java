package com.samju.hospital.repository;

import com.samju.hospital.entity.Laboratory;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryRepository extends MongoRepository<Laboratory, ObjectId> {
}
