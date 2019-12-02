package com.itrexgroup.vydrasergei.springmvcproject.service;

import com.itrexgroup.vydrasergei.springmvcproject.dto.BookDto;

import java.util.List;

public interface BookService {

    BookDto create(BookDto bookEntity);

    List<BookDto> getAllBooks();

    BookDto getBookByID(Long id);

    void delete(BookDto bookEntity);

    void update(BookDto bookEntity);
}
