package com.samju.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserDto {
    @Id
    private ObjectId id;
    private String username;
    private String fullName;
    private String password;
    private String phoneNumber;
    private String role;
    private Binary profilePicture;
}
