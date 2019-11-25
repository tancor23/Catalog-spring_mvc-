package com.itrexgroup.vydrasergei.springmvcproject.service;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.BookDAO;
import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.UserBookDAO;
import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.UserDAO;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.Book;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.User;
import com.itrexgroup.vydrasergei.springmvcproject.service.exception.ServiceException;

import java.util.List;

public interface UserBookService {

    List<Book> getAllMappedBookOfUser(Long userId) throws ServiceException;

    List<User> getAllMappedUserOfBook(Long bookId) throws ServiceException;

    boolean createByIds(Long userId, Long bookId) throws ServiceException;

    void setUserBookDAO(UserBookDAO userBookDAO);

    void setUserDAO(UserDAO userDAO);

    void setBookDAO(BookDAO bookDAO);
}
