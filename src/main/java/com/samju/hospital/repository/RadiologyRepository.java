package com.samju.hospital.repository;

import com.mongodb.client.MongoChangeStreamCursor;
import com.samju.hospital.entity.Radiology;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadiologyRepository extends MongoRepository<Radiology, ObjectId> {
}
