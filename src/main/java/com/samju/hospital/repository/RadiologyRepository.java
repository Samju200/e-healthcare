package com.samju.hospital.repository;

import com.mongodb.client.MongoChangeStreamCursor;
import com.samju.hospital.entity.Radiology;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RadiologyRepository extends MongoRepository<Radiology, Long> {
}
