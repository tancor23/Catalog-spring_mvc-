package com.itrexgroup.vydrasergei.springmvcproject.dao.mysql;

import com.itrexgroup.vydrasergei.springmvcproject.domain.util.mysql.Book;

import java.util.List;

public interface BookDAO {

    boolean create(Book book);

    List<Book> getAllBooks();

    void update(Book book);

    Book getById(Long key);

    void persist(Book entity);

    void delete(Book entity);
}