package com.itrexgroup.vydrasergei.springmvcproject.service;

import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.Book;

import java.util.List;

public interface BookService {

    void create(Book book);

    Book findBook(Long bookId);

    boolean editBook(Book book);

    List<Book> getAllBooks();

    boolean remove(Long bookId);

}
