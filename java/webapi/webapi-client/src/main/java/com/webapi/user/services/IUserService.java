package com.webapi.user.services;

import java.util.List;

import com.webapi.user.dto.UserDto;

public interface IUserService {
    List<UserDto> getAll();

    UserDto findById(Long userId);

    UserDto create(UserDto user);

    void update(Long userId, UserDto user);

    void inactive(Long userId);
}
