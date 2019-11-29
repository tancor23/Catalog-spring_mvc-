package com.itrexgroup.vydrasergei.springmvcproject.service;

import com.itrexgroup.vydrasergei.springmvcproject.domain.util.mysql.User;

import java.util.List;

public interface UserService {

    void create(User user);

    List<User> getAllUsers();

    User getUserByID(Long id);

    void delete(User user);

    void update(User user);

}
