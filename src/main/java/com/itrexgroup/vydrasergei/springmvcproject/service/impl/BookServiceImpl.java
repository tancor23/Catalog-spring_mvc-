package com.itrexgroup.vydrasergei.springmvcproject.service.impl;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.BookDAO;
import com.itrexgroup.vydrasergei.springmvcproject.domain.util.mysql.Book;
import com.itrexgroup.vydrasergei.springmvcproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Transactional
    @Override
    public void create(Book book) {
        bookDAO.create(book);
    }

    @Transactional
    @Override
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Transactional
    @Override
    public Book getBookByID(Long id) {
        return bookDAO.getById(id);
    }

    @Transactional
    @Override
    public void delete(Book book) {
        bookDAO.delete(book);
    }

    @Transactional
    @Override
    public void update(Book book) {
        bookDAO.update(book);
    }

}
