package com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.impl;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.BookDAO;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.Book;
import com.itrexgroup.vydrasergei.springmvcproject.domain.rowmapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class BookDAOImpl extends BookDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final String CHECK_BOOK_BY_ID_SQL = "SELECT id,name,author,page FROM books WHERE name=? and author=?;";
    private static final String ADD_NEW_BOOK_SQL = "INSERT INTO books (`name`, `author`, `page`) VALUES (?, ?, ?);";
    private static final String UPDATE_BOOK_SQL = "UPDATE books SET name=?, author=?, page=? WHERE id=?;";
    private static final String GET_BOOK_BY_ID_SQL = "SELECT * FROM books WHERE id=?;";
    private static final String GET_ALL_BOOKS_SQL = "SELECT * FROM books;";
    private static final String DELETE_BOOK_BY_ID_SQL = "DELETE FROM books WHERE id=?;";

    @Override
    public Book getBookInDB(String name, String author) {
        return jdbcTemplate.queryForObject(CHECK_BOOK_BY_ID_SQL, new Object[]{name, author}, new BookMapper());
    }

    @Override
    public boolean createBook(String name, String author, int countOfPage) {
        return jdbcTemplate.update(ADD_NEW_BOOK_SQL, name, author, countOfPage) > 0;
    }

    @Override
    public boolean create(Book book) {
        return createBook(book.getName(), book.getAuthor(), book.getPage());
    }

    @Override
    public Book findById(Long id) {
        return jdbcTemplate.queryForObject(GET_BOOK_BY_ID_SQL, new Object[]{id}, new BookMapper());
    }

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query(GET_ALL_BOOKS_SQL, new BookMapper());
    }

    @Override
    public boolean update(Book book) {
        return jdbcTemplate.update(UPDATE_BOOK_SQL, book.getName(), book.getAuthor(), book.getPage(), book.getId()) > 0;
    }

    @Override
    public boolean delete(Long id) {
        return jdbcTemplate.update(DELETE_BOOK_BY_ID_SQL, id) > 0;
    }
}
