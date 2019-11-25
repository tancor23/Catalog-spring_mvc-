package com.itrexgroup.vydrasergei.springmvcproject.dao;

import com.itrexgroup.vydrasergei.springmvcproject.dao.dbconfig.Datasource;
import com.itrexgroup.vydrasergei.springmvcproject.dao.dbconfig.MysqlDataSource;
import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.BookDAO;
import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.UserBookDAO;
import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.UserDAO;
import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.impl.BookDAOImpl;
import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.impl.UserBookDAOImpl;
import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory instance;
    private Datasource datasource;

    private final UserDAO userDAO;
    private final BookDAO bookDAO;
    private final UserBookDAO userBookDAO;

    private DAOFactory() {
        datasource = MysqlDataSource.getInstance();
        userDAO = new UserDAOImpl(datasource);
        bookDAO = new BookDAOImpl(datasource);
        userBookDAO = new UserBookDAOImpl(datasource);
    }

    public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            synchronized (DAOFactory.class) {
                if (instance == null) {
                    instance = new DAOFactory();
                }
            }
        }
        return instance;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public BookDAO getBookDAO() {
        return bookDAO;
    }

    public UserBookDAO getUserBookDAO() {
        return userBookDAO;
    }

}
