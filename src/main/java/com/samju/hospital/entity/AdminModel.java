package com.samju.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Document(collection = "admins")
public class AdminModel {
    @Id
    private String id;
    private String username;
    private String fullname;
    private String password;
    private int phoneNumber;
    private String role;


}
