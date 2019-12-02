package com.itrexgroup.vydrasergei.springmvcproject.service.impl;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.UserDao;
import com.itrexgroup.vydrasergei.springmvcproject.entity.UserEntity;
import com.itrexgroup.vydrasergei.springmvcproject.dto.ObjectMapperUtils;
import com.itrexgroup.vydrasergei.springmvcproject.dto.UserDto;
import com.itrexgroup.vydrasergei.springmvcproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService<UserDto> {

    @Autowired
    private UserDao userDAO;

    @Transactional
    @Override
    public UserDto create(UserDto userDto) {
        UserEntity userEntity = ObjectMapperUtils.map(userDto, UserEntity.class);
        UserDto newUserDto = ObjectMapperUtils.map(userDAO.create(userEntity), UserDto.class);
        System.out.println(newUserDto);
        return newUserDto;
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> allUserEntities = userDAO.getAllUsers();
        List<UserDto> userDtos = ObjectMapperUtils.mapAll(allUserEntities, UserDto.class);
        System.out.println(userDtos);
        return userDtos;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDto getUserByID(Long id) {
        return ObjectMapperUtils.map(userDAO.getById(id), UserDto.class);
    }

    @Transactional
    @Override
    public void delete(UserDto userDto) {
        userDAO.delete(ObjectMapperUtils.map(userDto, UserEntity.class));
    }

    @Transactional
    @Override
    public void update(UserDto userDto) {
        userDAO.update(ObjectMapperUtils.map(userDto, UserEntity.class));
    }

}
