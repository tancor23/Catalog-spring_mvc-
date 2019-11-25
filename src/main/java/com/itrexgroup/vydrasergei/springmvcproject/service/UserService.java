package com.itrexgroup.vydrasergei.springmvcproject.service;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.UserDAO;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.User;
import com.itrexgroup.vydrasergei.springmvcproject.service.exception.ServiceException;

import java.util.List;

public interface UserService {

    void create(User user) throws ServiceException;

    User findUser(Long userId) throws ServiceException;

    boolean editUser(User user) throws ServiceException;

    List<User> getAllUsers() throws ServiceException;

    void setUserDAO(UserDAO userDAO);

    boolean remove(Long userId) throws ServiceException;

}
