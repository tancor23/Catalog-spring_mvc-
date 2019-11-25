package com.itrexgroup.vydrasergei.springmvcproject.domain.rowmapper;

import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setCreatedAt(rs.getString("created_at"));
        return user;
    }
}
