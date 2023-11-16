package com.samju.hospital.service;


import com.samju.hospital.entity.Laboratory;
import com.samju.hospital.entity.Patient;
import com.samju.hospital.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
 public class LaboratoryService {
    @Autowired
    private LaboratoryRepository laboratoryRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Laboratory createLabTest(String fullName, String phoneNumber, String labReports, String registrationNumber) {


        Laboratory labTest = new Laboratory(fullName, phoneNumber, labReports);

        laboratoryRepository.insert(labTest);

        mongoTemplate.update(Patient.class)
                .matching(Criteria.where("registrationNumber").is(registrationNumber)).
                apply(new Update().push("laboratories").value(labTest) ).first();

        return labTest;
    }
}
