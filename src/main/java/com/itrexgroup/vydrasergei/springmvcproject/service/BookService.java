package com.itrexgroup.vydrasergei.springmvcproject.service;

import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.Book;

import java.util.List;

public interface BookService {

    void create(Book book);

    List<Book> getAllBooks();

    Book getBookByID(Long id);

    void delete(Book book);

    void update(Book book);
}
