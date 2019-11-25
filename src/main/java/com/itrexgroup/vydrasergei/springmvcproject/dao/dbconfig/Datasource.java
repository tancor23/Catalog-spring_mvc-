package com.itrexgroup.vydrasergei.springmvcproject.dao.dbconfig;

import java.sql.Connection;
import java.sql.SQLException;

public interface Datasource {
    Connection getConnection() throws InterruptedException;

    void init() throws SQLException, ClassNotFoundException;

    void destroy();
}
