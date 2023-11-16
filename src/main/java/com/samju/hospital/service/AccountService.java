package com.samju.hospital.service;

import com.samju.hospital.entity.Account;
import com.samju.hospital.entity.Patient;
import com.samju.hospital.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The {@code AccountService} class provides business logic for managing {@link Account} entities
 * in the hospital management system. It is annotated with {@link Service} to indicate that it is a
 * Spring service and should be automatically detected and registered in the application context.
 *
 * <p>The service relies on the {@link AccountRepository} for basic CRUD operations on accounts.
 * Additionally, it utilizes the {@link MongoTemplate} for more complex MongoDB-specific operations.
 *
 * <p>Methods in this service include:
 * <ul>
 *   <li>{@link #createAmount(String, String, String, String)}: Create a new account and associate it with a patient.</li>
 * </ul>
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * public class SomeController {
 *     AccountService accountService;
 *
 *     // Some method that uses the service
 *     void someMethod() {
 *         Account newAccount = accountService.createAmount("John Doe", "123-456-7890", "1000", "P123");
 *         // Perform operations with the created account
 *     }
 * }
 * }
 * </pre>
 *
 * @see Service
 * @see AccountRepository
 * @see MongoTemplate
 * @see Account
 * @version 1.0
 */
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Create a new account and associate it with a patient identified by the registration number.
     *
     * @param fullName          The full name associated with the account.
     * @param phoneNumber       The contact phone number associated with the account.
     * @param amount            The initial amount in the account.
     * @param registrationNumber The registration number of the patient to associate the account with.
     * @return The created account.
     */
    public Account createAmount(String fullName, String phoneNumber, String amount, String registrationNumber) {

        // Create a new account
        Account totalAmount = new Account(fullName, phoneNumber, amount);
        accountRepository.insert(totalAmount);

        // Update the patient with the newly created account
        mongoTemplate.update(Patient.class)
                .matching(Criteria.where("registrationNumber").is(registrationNumber))
                .apply(new Update().push("account").value(totalAmount))
                .first();

        return totalAmount;
    }
    /**
     * Retrieve a list of all accountants.
     *
     * @return A {@link List} of {@link Account} objects representing all accountants.
     * @see AccountRepository#findAll()
     */
    public List<Account> findAllAccountants() {
        return accountRepository.findAll();
    }

}
