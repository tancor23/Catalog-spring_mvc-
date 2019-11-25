package com.itrexgroup.vydrasergei.springmvcproject.dao.mysql;

import com.itrexgroup.vydrasergei.springmvcproject.dao.GenericDAO;
import com.itrexgroup.vydrasergei.springmvcproject.dao.dbconfig.Datasource;
import com.itrexgroup.vydrasergei.springmvcproject.dao.exception.DAOException;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.Book;

import java.util.List;

public abstract class BookDAO extends GenericDAO<Book, Long> {

    public BookDAO(Datasource datasource) {
        super(datasource);
    }

    public abstract Book getBookInDB(String name, String author) throws DAOException;

    public abstract boolean createBook(String name, String author, int countOfPage) throws DAOException;

    public abstract List<Long> getAllMappedUserIds(Long bookId) throws DAOException;

}