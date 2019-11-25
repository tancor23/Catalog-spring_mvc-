package com.itrexgroup.vydrasergei.springmvcproject.service.impl;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.BookDAO;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.Book;
import com.itrexgroup.vydrasergei.springmvcproject.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public void create(Book book) {

    }

    @Override
    public Book findBook(Long bookId) {
        return null;
    }

    @Override
    public boolean editBook(Book book) {
        return false;
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public void setBookDAO(BookDAO bookDAO) {

    }

    @Override
    public boolean remove(Long bookId) {
        return false;
    }
}
