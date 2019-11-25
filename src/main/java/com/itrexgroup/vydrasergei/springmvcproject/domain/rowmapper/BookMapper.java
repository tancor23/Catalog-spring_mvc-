package com.itrexgroup.vydrasergei.springmvcproject.domain.rowmapper;

import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int i) throws SQLException {
        Book book = new Book();
        book.setId(rs.getLong("id"));
        book.setName(rs.getString("name"));
        book.setAuthor(rs.getString("author"));
        book.setPage(rs.getInt("page"));
        return book;
    }
}
