package com.itrexgroup.vydrasergei.springmvcproject.service.impl;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.UserDAO;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.User;
import com.itrexgroup.vydrasergei.springmvcproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public void create(User user) {

    }

    @Override
    public User findUser(Long userId) {
        return userDAO.findById(userId);
    }

    @Override
    public boolean editUser(User user) {
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void setUserDAO(UserDAO userDAO) {

    }

    @Override
    public boolean remove(Long userId) {
        return false;
    }
}
