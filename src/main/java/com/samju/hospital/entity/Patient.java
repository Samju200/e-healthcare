package com.samju.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Document(collection = "patients")
public class Patient {
    @Id
    private ObjectId id;
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
    @DocumentReference
    private List<Doctor> doctorRecords;
    @DocumentReference
    private List<Nurse> nurseRecords;
    @DocumentReference
    private List<Laboratory> laboratoryResults;
    @DocumentReference
    private List<Radiology> radiologyRecords;
    @DocumentReference
    private List<Pharmacy> pharmacyRecords;
    @DocumentReference
    private List<Accountant> accountantRecords;

}
