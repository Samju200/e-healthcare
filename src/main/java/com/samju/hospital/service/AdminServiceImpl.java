package com.samju.hospital.service;

import com.samju.hospital.entity.AdminUser;
import com.samju.hospital.entity.AdminUserDto;
import com.samju.hospital.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import com.samju.hospital.config.SecurityConfig.PasswordEncoder;
import org.springframework.context.annotation.Import;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminRepository adminRepository;



    @Override
    public AdminUser createUser(AdminUserDto adminUserDto) {
        AdminUser newAdminUser = new AdminUser();
newAdminUser.setUsername(adminUserDto.getUsername());
    newAdminUser.setFullname(adminUserDto.getFullname());
    newAdminUser.setPassword(adminUserDto.getPassword());
    newAdminUser.setPhoneNumber(adminUserDto.getPhoneNumber());
    newAdminUser.setRole(adminUserDto.getRole());
//        Optional<AdminUser> existingAdminUser = adminRepository.findByUsername(newAdminUser.getUsername());
//        if(existingAdminUser.isPresent()){
//            return null;
//        }
   return adminRepository.save(newAdminUser);
    }

    @Override
    public Optional<AdminUser> login(String username, String password) {
        Optional<AdminUser> adminUserOptional = adminRepository.findByUsername(username);

        if (adminUserOptional.isPresent()) {
            AdminUser adminUser = adminUserOptional.get();

            // Check if the provided password matches the stored password (consider using a password encoder)
            if (password.equals(adminUser.getPassword())) {
                return Optional.of(adminUser);
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<AdminUser> usernameCheck(String username) {
        Optional<AdminUser> adminUserOptional = adminRepository.findByUsername(username);
        if (adminUserOptional.isPresent()) {
            AdminUser adminUser = adminUserOptional.get();
            return Optional.of(adminUser);
        }
        return Optional.empty();
    }
}

