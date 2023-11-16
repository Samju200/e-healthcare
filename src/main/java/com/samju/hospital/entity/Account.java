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
@Document(collection = "accounts")
public class Account {
    @Id
    private ObjectId id;
    private String fullName;
    private String phoneNumber;
    private  String amount;
    private String time;
    private int day;
    private Month month;
    private int year;

    public Account(String fullName, String amount , String phoneNumber) {
        this.fullName = fullName;
        this.amount = amount;
        this.phoneNumber =  phoneNumber;
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.time  = currentTime.format(formatter);
        this.day = LocalDate.now().getDayOfMonth();
        this.month = YearMonth.now().getMonth();
        this.year = Year.now().getValue();
    }
}
