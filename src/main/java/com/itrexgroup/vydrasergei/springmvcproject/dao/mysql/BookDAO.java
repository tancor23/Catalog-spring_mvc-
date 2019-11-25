package com.itrexgroup.vydrasergei.springmvcproject.dao.mysql;

import com.itrexgroup.vydrasergei.springmvcproject.dao.GenericDAO;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.Book;

import java.util.List;

public abstract class BookDAO extends GenericDAO<Book, Long> {

    public abstract Book getBookInDB(String name, String author);

    public abstract boolean createBook(String name, String author, int countOfPage);

}