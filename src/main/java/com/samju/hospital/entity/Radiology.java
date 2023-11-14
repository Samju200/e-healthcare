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
@Document(collection = "radiologists")
public class Radiology {
    @Id
    private ObjectId id;
    private String name;
    private int phoneNumber;
    private String images;
    private String reports;
}
