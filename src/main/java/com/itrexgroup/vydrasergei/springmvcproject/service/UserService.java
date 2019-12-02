package com.itrexgroup.vydrasergei.springmvcproject.service;

import com.itrexgroup.vydrasergei.springmvcproject.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto create(UserDto user);

    List<UserDto> getAllUsers();

    UserDto getUserByID(Long id);

    void delete(UserDto user);

    void update(UserDto user);

}
