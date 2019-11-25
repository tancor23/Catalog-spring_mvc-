package com.itrexgroup.vydrasergei.springmvcproject.service.impl;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.BookDAO;
import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.UserBookDAO;
import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.UserDAO;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.Book;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.User;
import com.itrexgroup.vydrasergei.springmvcproject.service.UserBookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserBookServiceImpl implements UserBookService {
    private final static Logger LOGGER = LogManager.getLogger(UserBookServiceImpl.class);
    private UserDAO userDAO;
    private BookDAO bookDAO;
    private UserBookDAO userBookDAO;


    @Override
    public List<Book> getAllMappedBookOfUser(Long userId) {
        return null;
    }

    @Override
    public List<User> getAllMappedUserOfBook(Long bookId) {
        return null;
    }

    @Override
    public boolean createByIds(Long userId, Long bookId) {
        return false;
    }

    @Override
    public void setUserBookDAO(UserBookDAO userBookDAO) {

    }

    @Override
    public void setUserDAO(UserDAO userDAO) {

    }

    @Override
    public void setBookDAO(BookDAO bookDAO) {

    }
}
