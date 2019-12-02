package com.itrexgroup.vydrasergei.springmvcproject.dao.mysql;

import com.itrexgroup.vydrasergei.springmvcproject.entity.UserEntity;

import java.util.List;

public interface UserDao {

    UserEntity create(UserEntity userEntity);

    List<UserEntity> getAllUsers();

    void update(UserEntity userEntity);

    UserEntity getById(Long key);

    void persist(UserEntity entity);

    void delete(UserEntity entity);

    //List<Book> mappedBooks();
}