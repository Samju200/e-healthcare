package com.samju.hospital.service;
import com.samju.hospital.entity.User;
import com.samju.hospital.entity.UserDto;

import java.util.Optional;

public interface UserService {

    User createUser(UserDto userDto);
    Optional<User> login(String username, String password);
    Optional<User> usernameCheck(String username);
}
