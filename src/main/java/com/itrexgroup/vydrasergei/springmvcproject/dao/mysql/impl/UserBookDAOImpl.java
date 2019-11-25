package com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.impl;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.UserBookDAO;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.UserBook;
import com.itrexgroup.vydrasergei.springmvcproject.domain.rowmapper.UserBookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class UserBookDAOImpl extends UserBookDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserBookDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final String ADD_USER_BOOK_BY_IDS_SQL = "INSERT INTO user_book(user_id, book_id) VALUES(?,?);";
    private static final String GET_ALL_USER_BOOKS_SQL = "SELECT * FROM user_book;";
    private static final String SELECT_ALL_MAPPED_BOOK_ID_SQL = "SELECT book_id FROM user_book WHERE user_id=?;";
    private static final String SELECT_ALL_MAPPED_USER_ID_SQL = "SELECT user_id FROM user_book WHERE book_id=?;";

    @Override
    public boolean createByIds(Long userId, Long bookId) {
        return jdbcTemplate.update(ADD_USER_BOOK_BY_IDS_SQL, userId, bookId) > 0;
    }

    @Override
    public List<Long> getAllMappedBookIds(Long userId) {
        return jdbcTemplate.queryForList(SELECT_ALL_MAPPED_BOOK_ID_SQL, new Object[]{userId}, Long.class);
    }

    @Override
    public List<Long> getAllMappedUserIds(Long bookId) {
        return jdbcTemplate.queryForList(SELECT_ALL_MAPPED_USER_ID_SQL, new Object[]{bookId}, Long.class);
    }

    @Override
    public boolean create(UserBook userBook) {
        return createByIds(userBook.getUserId(), userBook.getBookId());
    }

    //doesn't use
    @Override
    public UserBook findById(Long id) {
        return null;
    }

    @Override
    public List<UserBook> findAll() {
        return jdbcTemplate.query(GET_ALL_USER_BOOKS_SQL, new UserBookMapper());
    }

    @Override
    public boolean update(UserBook userBook) {
        return false;
    }

    //doesn't use
    @Override
    public boolean delete(Long id) {
        return false;
    }
}
