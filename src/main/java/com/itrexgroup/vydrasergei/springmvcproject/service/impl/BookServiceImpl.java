package com.itrexgroup.vydrasergei.springmvcproject.service.impl;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.BookDao;
import com.itrexgroup.vydrasergei.springmvcproject.dto.BookDto;
import com.itrexgroup.vydrasergei.springmvcproject.dto.ObjectMapperUtils;
import com.itrexgroup.vydrasergei.springmvcproject.entity.BookEntity;
import com.itrexgroup.vydrasergei.springmvcproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDAO;

    @Transactional
    @Override
    public BookDto create(BookDto bookDto) {
        BookEntity bookEntity = ObjectMapperUtils.map(bookDto, BookEntity.class);
        return ObjectMapperUtils.map(bookDAO.create(bookEntity), BookDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public List<BookDto> getAllBooks() {
        return ObjectMapperUtils.mapAll(bookDAO.getAllBooks(), BookDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public BookDto getBookByID(Long id) {
        return ObjectMapperUtils.map(bookDAO.getById(id), BookDto.class);
    }

    @Transactional
    @Override
    public void delete(BookDto bookDto) {
        bookDAO.delete(ObjectMapperUtils.map(bookDto, BookEntity.class));
    }

    @Transactional
    @Override
    public void update(BookDto bookDto) {
        bookDAO.update(ObjectMapperUtils.map(bookDto, BookEntity.class));
    }

}
