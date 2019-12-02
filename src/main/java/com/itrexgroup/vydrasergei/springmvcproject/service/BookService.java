package com.itrexgroup.vydrasergei.springmvcproject.service;

import java.util.List;

public interface BookService<T> {

    T create(T bookEntity);

    List<T> getAllBooks();

    T getBookByID(Long id);

    void delete(T bookEntity);

    void update(T bookEntity);
}
