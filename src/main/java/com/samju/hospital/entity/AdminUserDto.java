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
public class AdminUserDto {
    @Id
    private String id;
    private String username;
    private String fullname;
    private String password;
    private String phoneNumber;
    private String role;
}
