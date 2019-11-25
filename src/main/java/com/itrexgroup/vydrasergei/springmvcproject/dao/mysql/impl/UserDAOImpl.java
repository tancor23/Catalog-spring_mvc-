package com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.impl;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.UserDAO;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.User;
import com.itrexgroup.vydrasergei.springmvcproject.domain.rowmapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class UserDAOImpl extends UserDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final String CHECK_USER_BY_ID_SQL = "SELECT id,first_name,last_name,created_at FROM users WHERE first_name=? and last_name=?;";
    private static final String ADD_NEW_USER_SQL = "INSERT INTO users (`first_name`, `last_name`) VALUES (?, ?);";
    private static final String UPDATE_USER_SQL = "UPDATE users SET first_name=?, last_name=? WHERE id=?;";
    private static final String GET_USER_BY_ID_SQL = "SELECT * FROM users WHERE id=?;";
    private static final String GET_ALL_USERS_SQL = "SELECT * FROM users;";
    private static final String DELETE_USER_BY_ID_SQL = "DELETE FROM users WHERE id=?;";

    @Override
    public User getUserFromDB(String firstName, String lastName) {
        // return (User) jdbcTemplate.queryForObject(CHECK_USER_BY_ID_SQL, new Object[]{firstName, lastName}, new BeanPropertyRowMapper(User.class));
        return jdbcTemplate.queryForObject(CHECK_USER_BY_ID_SQL, new Object[]{firstName, lastName}, new UserMapper());
    }

    @Override
    public boolean createUser(String firstName, String lastName) {
        return jdbcTemplate.update(ADD_NEW_USER_SQL, firstName, lastName) > 0;
    }

    @Override
    public boolean create(User user) {
        return createUser(user.getFirstName(), user.getLastName());
    }

    @Override
    public User findById(Long id) {
        return jdbcTemplate.queryForObject(GET_USER_BY_ID_SQL, new Object[]{id}, new UserMapper());
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(GET_ALL_USERS_SQL, new UserMapper());
    }

    @Override
    public boolean update(User user) {
        return jdbcTemplate.update(UPDATE_USER_SQL, user.getFirstName(), user.getLastName(), user.getId()) > 0;
    }

    @Override
    public boolean delete(Long id) {
        return jdbcTemplate.update(DELETE_USER_BY_ID_SQL, id) > 0;
    }

}
