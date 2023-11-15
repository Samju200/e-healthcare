package com.samju.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Document(collection = "doctors")
public class Doctor {

    @Id
    private ObjectId id;

    private String name;
    private String phoneNumber;
    private String department;
    private String reports;

    public Doctor(String name, String phoneNumber, String department, String reports) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.reports = reports;
    }
}
