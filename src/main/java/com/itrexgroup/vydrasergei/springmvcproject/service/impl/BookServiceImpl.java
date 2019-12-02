package com.itrexgroup.vydrasergei.springmvcproject.service.impl;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.BookDao;
import com.itrexgroup.vydrasergei.springmvcproject.entity.BookEntity;
import com.itrexgroup.vydrasergei.springmvcproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookDao bookDAO;

    @Autowired
    public BookServiceImpl(BookDao bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public BookEntity create(BookEntity bookEntity) {
        return bookDAO.create(bookEntity);
    }

    @Override
    public List<BookEntity> getAllBookEntity() {
        return bookDAO.getAllBooks();
    }

    @Override
    public BookEntity getBookEntityByID(Long id) {
        return bookDAO.getById(id);
    }

    @Override
    public void delete(BookEntity bookEntity) {
        bookDAO.delete(bookEntity);
    }

    @Override
    public void update(BookEntity bookEntity) {
        bookDAO.update(bookEntity);
    }

}
