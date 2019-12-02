package com.itrexgroup.vydrasergei.springmvcproject.service;

import com.itrexgroup.vydrasergei.springmvcproject.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity create(UserEntity user);

    List<UserEntity> getAllUserEntity();

    UserEntity getUserEntityByID(Long id);

    void delete(UserEntity userEntity);

    void update(UserEntity userEntity);

}
