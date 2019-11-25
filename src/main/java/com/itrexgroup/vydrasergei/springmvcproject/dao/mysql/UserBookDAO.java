package com.itrexgroup.vydrasergei.springmvcproject.dao.mysql;

import com.itrexgroup.vydrasergei.springmvcproject.dao.GenericDAO;
import com.itrexgroup.vydrasergei.springmvcproject.dao.dbconfig.Datasource;
import com.itrexgroup.vydrasergei.springmvcproject.dao.exception.DAOException;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.UserBook;

public abstract class UserBookDAO extends GenericDAO<UserBook, Long> {

    public UserBookDAO(Datasource datasource) {
        super(datasource);
    }

    public abstract boolean createByIds(Long userId, Long bookId) throws DAOException;

}