package com.samju.hospital.service;

import com.samju.hospital.entity.Doctor;
import com.samju.hospital.entity.Nurse;
import com.samju.hospital.entity.Patient;
import com.samju.hospital.repository.DoctorRepository;
import com.samju.hospital.repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class NurseService {

    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Nurse createNurseReport(String fullName, String phoneNumber, String department, String reports, String registrationNumber) {


        Nurse nurseReport = new Nurse(fullName, phoneNumber, department, reports);

        nurseRepository.insert(nurseReport);

        mongoTemplate.update(Patient.class)
                .matching(Criteria.where("registrationNumber").is(registrationNumber)).
                apply(new Update().push("nurses").value(nurseReport) ).first();

        return nurseReport;
    }
}
