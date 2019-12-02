package com.itrexgroup.vydrasergei.springmvcproject.service;

import com.itrexgroup.vydrasergei.springmvcproject.entity.BookEntity;

import java.util.List;

public interface BookService {

    BookEntity create(BookEntity bookEntity);

    List<BookEntity> getAllBookEntity();

    BookEntity getBookEntityByID(Long id);

    void delete(BookEntity bookEntity);

    void update(BookEntity bookEntity);
}
