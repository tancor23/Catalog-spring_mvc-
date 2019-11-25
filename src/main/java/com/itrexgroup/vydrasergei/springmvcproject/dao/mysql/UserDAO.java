package com.itrexgroup.vydrasergei.springmvcproject.dao.mysql;

import com.itrexgroup.vydrasergei.springmvcproject.dao.GenericDAO;
import com.itrexgroup.vydrasergei.springmvcproject.dao.dbconfig.Datasource;
import com.itrexgroup.vydrasergei.springmvcproject.dao.exception.DAOException;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.User;

import java.util.List;

public abstract class UserDAO extends GenericDAO<User, Long> {

    public UserDAO(Datasource datasource) {
        super(datasource);
    }

    public abstract User getUserInDB(String firstName, String lastName) throws DAOException;

    public abstract boolean createUser(String firstName, String lastName) throws DAOException;

    public abstract List<Long> getAllMappedBookIds(Long userId) throws DAOException;

}