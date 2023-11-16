package com.samju.hospital.service;

import com.samju.hospital.entity.Patient;
import com.samju.hospital.entity.Pharmacy;
import com.samju.hospital.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class PharmacyService {
    @Autowired
    private PharmacyRepository pharmacyRepository;
    @Autowired
    private MongoTemplate mongoTemplate;


    public Pharmacy createDrugAdminister(String fullName, String phoneNumber, String drugs, String registrationNumber){

        Pharmacy drugAdminister = new Pharmacy( fullName, phoneNumber, drugs);

        pharmacyRepository.insert(drugAdminister);

        mongoTemplate.update(Patient.class)
                .matching(Criteria.where("registrationNumber").is(registrationNumber)).
                apply(new Update().push("pharmacies").value(drugAdminister) ).first();
        return drugAdminister;
    }
}
