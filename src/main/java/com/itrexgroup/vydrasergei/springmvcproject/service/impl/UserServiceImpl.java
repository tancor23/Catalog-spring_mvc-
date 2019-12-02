package com.itrexgroup.vydrasergei.springmvcproject.service.impl;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.UserDao;
import com.itrexgroup.vydrasergei.springmvcproject.entity.UserEntity;
import com.itrexgroup.vydrasergei.springmvcproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDAO;

    @Autowired
    public UserServiceImpl(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserEntity create(UserEntity userEntity) {
        userDAO.create(userEntity);
        return userEntity;
    }

    @Override
    public List<UserEntity> getAllUserEntity() {
        return userDAO.getAllUsers();
    }

    @Override
    public UserEntity getUserEntityByID(Long id) {
        return userDAO.getById(id);
    }

    @Override
    public void delete(UserEntity userEntity) {
        userDAO.delete(userEntity);
    }

    @Override
    public void update(UserEntity userEntity) {
        userDAO.update(userEntity);
    }

}
