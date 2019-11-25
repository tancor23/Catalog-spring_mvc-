package com.itrexgroup.vydrasergei.springmvcproject.service;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.UserDAO;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.User;

import java.util.List;

public interface UserService {

    void create(User user);

    User findUser(Long userId);

    boolean editUser(User user);

    List<User> getAllUsers();

    void setUserDAO(UserDAO userDAO);

    boolean remove(Long userId);

}
