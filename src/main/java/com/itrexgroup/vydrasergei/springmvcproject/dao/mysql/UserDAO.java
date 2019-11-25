package com.itrexgroup.vydrasergei.springmvcproject.dao.mysql;

import com.itrexgroup.vydrasergei.springmvcproject.dao.GenericDAO;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.User;

import java.util.List;

public abstract class UserDAO extends GenericDAO<User, Long> {

    public abstract User getUserFromDB(String firstName, String lastName);

    public abstract boolean createUser(String firstName, String lastName);

}