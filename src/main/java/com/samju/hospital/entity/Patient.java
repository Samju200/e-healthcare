package com.samju.hospital.entity;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Patient {
    @Id
    private Long id;

    private String name;
    private int age;

    private List<Doctor> doctorRecords;
    private List<Nurse> nurseRecords;
    private List<Laboratory> laboratoryResults;
    private List<Radiology> radiologyRecords;
    private List<Pharmacy> pharmacyRecords;
    private List<Accountant> accountantRecords;

}
