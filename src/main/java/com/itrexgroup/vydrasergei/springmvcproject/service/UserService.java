package com.itrexgroup.vydrasergei.springmvcproject.service;

import java.util.List;

public interface UserService<T> {

    T create(T user);

    List<T> getAllUsers();

    T getUserByID(Long id);

    void delete(T user);

    void update(T user);

}
