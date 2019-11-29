package com.itrexgroup.vydrasergei.springmvcproject.dao.mysql;

import com.itrexgroup.vydrasergei.springmvcproject.domain.util.mysql.User;

import java.util.List;

public interface UserDAO {

    boolean create(User user);

    List<User> getAllUsers();

    void update(User user);

    User getById(Long key);

    void persist(User entity);

    void delete(User entity);

    //List<Book> mappedBooks();
}