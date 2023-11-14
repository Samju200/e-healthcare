package com.samju.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Document(collection = "patients")
public class Patient {
    @Id
    private Long id;
    private String registrationType;
    private String hmoType;
    private String registrationNumber;

    private String hmoNumber;
    private String patientStatus;
    private String title;
    private String surname;
    private String firstname;
    private String phoneNumber;
    private String address;
    private Date dateOfBirth;
    private int age;
    private String nextOfKinName;
    private String nextOfKinPhoneNumber;
    private String nextOfKinAddress;

    private List<Doctor> doctorRecords;
    private List<Nurse> nurseRecords;
    private List<Laboratory> laboratoryResults;
    private List<Radiology> radiologyRecords;
    private List<Pharmacy> pharmacyRecords;
    private List<Accountant> accountantRecords;

}
