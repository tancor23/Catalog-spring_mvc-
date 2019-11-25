package com.itrexgroup.vydrasergei.springmvcproject.domain.rowmapper;

import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.UserBook;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBookMapper implements RowMapper<UserBook> {
    @Override
    public UserBook mapRow(ResultSet rs, int i) throws SQLException {
        UserBook userBook = new UserBook();
        userBook.setUserId(rs.getLong("user_id"));
        userBook.setBookId(rs.getLong("book_id"));
        return userBook;
    }
}
