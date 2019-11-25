package com.itrexgroup.vydrasergei.springmvcproject.service.impl;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.BookDAO;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.Book;
import com.itrexgroup.vydrasergei.springmvcproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public void create(Book book) {
        bookDAO.create(book);
    }

    @Override
    public Book findBook(Long bookId) {
        return bookDAO.findById(bookId);
    }

    @Override
    public boolean editBook(Book book) {
        return bookDAO.update(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }

    @Override
    public boolean remove(Long bookId) {
        return bookDAO.delete(bookId);
    }
}
