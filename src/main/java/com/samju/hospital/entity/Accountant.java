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
@Document(collection = "accountants")
public class Accountant {
    @Id
    private ObjectId id;
    private String fullName;

    private double amount;
}
