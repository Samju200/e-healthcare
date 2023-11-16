package com.samju.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.*;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Document(collection = "laboratories")
public class Laboratory {
    @Id
    private ObjectId id;
    private String fullName;
    private String phoneNumber;
    private String testReports;
    private String time;
    private int day;
    private Month month;
    private int year;

    public Laboratory(String fullName, String phoneNumber, String testReports) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.testReports = testReports;
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.time  = currentTime.format(formatter);
        this.day = LocalDate.now().getDayOfMonth();
        this.month = YearMonth.now().getMonth();
        this.year = Year.now().getValue();
    }
}
