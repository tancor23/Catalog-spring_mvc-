package com.itrexgroup.vydrasergei.springmvcproject.service;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.BookDAO;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.Book;
import com.itrexgroup.vydrasergei.springmvcproject.service.exception.ServiceException;

import java.util.List;

public interface BookService {

    void create(Book book) throws ServiceException;

    Book findBook(Long bookId) throws ServiceException;

    boolean editBook(Book book) throws ServiceException;

    List<Book> getAllBooks() throws ServiceException;

    void setBookDAO(BookDAO bookDAO);

    boolean remove(Long bookId) throws ServiceException;

}
