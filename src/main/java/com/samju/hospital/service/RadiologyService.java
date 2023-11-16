package com.samju.hospital.service;

import com.samju.hospital.entity.Patient;
import com.samju.hospital.entity.Radiology;

import com.samju.hospital.repository.RadiologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class RadiologyService {
    @Autowired
    private RadiologyRepository radiologyRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Radiology createScan(String fullName, String phoneNumber, String images, String reports, String registrationNumber){

        Radiology scannerResults = new Radiology(fullName, phoneNumber, images, reports);
    radiologyRepository.insert(scannerResults);
        mongoTemplate.update(Patient.class)
                .matching(Criteria.where("registrationNumber").is(registrationNumber)).
                apply(new Update().push("radiologys").value(scannerResults) ).first();
        return scannerResults;
    }
}
