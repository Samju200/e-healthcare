package com.samju.hospital.repository;

import com.samju.hospital.entity.AdminModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<AdminModel, String> {
}
