package com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.impl;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.UserBookDAO;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.UserBook;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserBookDAOImpl implements UserBookDAO {

    @Override
    public boolean createByIds(Long userId, Long bookId) {
        return false;
    }

    @Override
    public List<Long> getAllMappedBookIds(Long userId) {
        return null;
    }

    @Override
    public List<Long> getAllMappedUserIds(Long bookId) {
        return null;
    }
}
