package com.samju.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Data
@AllArgsConstructor
@Builder
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
    private String dateOfBirth;
    private String age;
    private String nextOfKinName;
    private String nextOfKinPhoneNumber;
    private String nextOfKinAddress;
    private String time;
    private int day;
    private Month month;
    private int year;
    @DocumentReference
    private List<Doctor> doctor;
    @DocumentReference
    private List<Nurse> nurse;
    @DocumentReference
    private List<Laboratory> laboratory;
    @DocumentReference
    private List<Radiology> radiology;
    @DocumentReference
    private List<Pharmacy> pharmacy;
    @DocumentReference
    private List<Account> account;

    public Patient() {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.time  = currentTime.format(formatter);
        this.day = LocalDate.now().getDayOfMonth();
        this.month = YearMonth.now().getMonth();
        this.year = Year.now().getValue();

    }
}
