package com.samju.hospital.service;

import com.samju.hospital.entity.User;
import com.samju.hospital.entity.UserDto;
import com.samju.hospital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import com.samju.hospital.config.SecurityConfig.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;



    @Override
    public User createUser(UserDto userDto) {
        User newUser = new User();
newUser.setUsername(userDto.getUsername());
    newUser.setFullName(userDto.getFullName());
    newUser.setPassword(userDto.getPassword());
    newUser.setPhoneNumber(userDto.getPhoneNumber());
    newUser.setRole(userDto.getRole());
   return userRepository.save(newUser);
    }

    @Override
    public Optional<User> login(String username, String password) {
        Optional<User> adminUserOptional = userRepository.findByUsername(username);

        if (adminUserOptional.isPresent()) {
            User user = adminUserOptional.get();

            // Check if the provided password matches the stored password (consider using a password encoder)
            if (password.equals(user.getPassword())) {
                return Optional.of(user);
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<User> usernameCheck(String username) {
        Optional<User> adminUserOptional = userRepository.findByUsername(username);
        if (adminUserOptional.isPresent()) {
            User user = adminUserOptional.get();
            return Optional.of(user);
        }
        return Optional.empty();
    }
}

