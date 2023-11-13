package com.samju.hospital.service;
import com.samju.hospital.entity.AdminUser;
import com.samju.hospital.entity.AdminUserDto;

import java.util.Optional;

public interface AdminService {

    AdminUser createUser(AdminUserDto adminUserDto);
    Optional<AdminUser> login(String username, String password);
    Optional<AdminUser> usernameCheck(String username);
}
