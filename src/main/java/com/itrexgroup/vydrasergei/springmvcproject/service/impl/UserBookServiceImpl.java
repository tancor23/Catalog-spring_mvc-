package com.itrexgroup.vydrasergei.springmvcproject.service.impl;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.BookDAO;
import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.UserBookDAO;
import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.UserDAO;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.Book;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.User;
import com.itrexgroup.vydrasergei.springmvcproject.service.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserBookServiceImpl implements UserBookService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private UserBookDAO userBookDAO;


    @Override
    public List<Book> getAllMappedBookOfUser(Long userId) {
        List<Long> allMappedBookIds = userBookDAO.getAllMappedBookIds(userId);
        List<Book> books = new ArrayList<>();
        for (Long bookId : allMappedBookIds) {
            books.add(bookDAO.findById(bookId));
        }
        return books;
    }

    @Override
    public List<User> getAllMappedUserOfBook(Long bookId) {
        List<Long> allMappedUserIds = userBookDAO.getAllMappedUserIds(bookId);
        List<User> users = new ArrayList<>();
        for (Long userId : allMappedUserIds) {
            users.add(userDAO.findById(userId));
        }
        return users;
    }

    @Override
    public boolean createByIds(Long userId, Long bookId) {
        return userBookDAO.createByIds(userId, bookId);
    }

}
