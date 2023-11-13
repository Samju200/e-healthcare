package com.samju.hospital.repository;

import com.samju.hospital.entity.AdminUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AdminRepository extends MongoRepository<AdminUser, String> {
    Optional<AdminUser> findByUsername(String username);
}
