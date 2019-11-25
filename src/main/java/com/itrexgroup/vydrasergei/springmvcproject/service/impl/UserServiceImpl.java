package com.itrexgroup.vydrasergei.springmvcproject.service.impl;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.UserDAO;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.User;
import com.itrexgroup.vydrasergei.springmvcproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void create(User user) {
        userDAO.create(user);
    }

    @Override
    public User findUser(Long userId) {
        return userDAO.findById(userId);
    }

    @Override
    public boolean editUser(User user) {
        return userDAO.update(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
    public boolean remove(Long userId) {
        return userDAO.delete(userId);
    }
}
