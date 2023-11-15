package com.samju.hospital.service;

import com.samju.hospital.entity.Doctor;
import com.samju.hospital.entity.Patient;
import com.samju.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Doctor createDoctorReport(String name, String phoneNumber, String department, String reports, String registrationNumber) {


        Doctor doctorConsult = new Doctor(name, phoneNumber, department, reports);

        doctorRepository.insert(doctorConsult);

        mongoTemplate.update(Patient.class)
                .matching(Criteria.where("registrationNumber").is(registrationNumber)).
                apply(new Update().push("doctorConsult").value(doctorConsult) ).first();

        return doctorConsult;
    }
}