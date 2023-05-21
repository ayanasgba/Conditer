package com.example.Conditer.service;

import com.example.Conditer.dto.UserDto;
import com.example.Conditer.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
