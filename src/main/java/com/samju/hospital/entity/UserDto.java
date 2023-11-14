package com.samju.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserDto {
    @Id
    private Long id;
    private String username;
    private String fullName;
    private String password;
    private int phoneNumber;
    private String role;
}
