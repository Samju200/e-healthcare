package com.samju.hospital.service;

import com.samju.hospital.entity.Account;
import com.samju.hospital.entity.Patient;
import com.samju.hospital.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Account createAmount(String fullName, String phoneNumber, String amount, String registrationNumber){

        Account totalAmount = new Account(fullName, phoneNumber, amount);
accountRepository.insert(totalAmount);
        mongoTemplate.update(Patient.class)
                .matching(Criteria.where("registrationNumber").is(registrationNumber)).
                apply(new Update().push("accounts").value(totalAmount) ).first();
        return totalAmount;
    }
}
