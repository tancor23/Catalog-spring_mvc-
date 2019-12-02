package com.itrexgroup.vydrasergei.springmvcproject.dao.mysql;

import com.itrexgroup.vydrasergei.springmvcproject.entity.BookEntity;

import java.util.List;

public interface BookDao {

    BookEntity create(BookEntity bookEntity);

    List<BookEntity> getAllBooks();

    void update(BookEntity bookEntity);

    BookEntity getById(Long key);

    void persist(BookEntity entity);

    void delete(BookEntity entity);
}