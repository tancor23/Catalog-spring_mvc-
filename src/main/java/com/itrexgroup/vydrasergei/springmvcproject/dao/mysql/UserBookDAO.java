package com.itrexgroup.vydrasergei.springmvcproject.dao.mysql;

import com.itrexgroup.vydrasergei.springmvcproject.dao.GenericDAO;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.UserBook;

import java.util.List;

public abstract class UserBookDAO extends GenericDAO<UserBook, Long> {

    public abstract boolean createByIds(Long userId, Long bookId);

    public abstract List<Long> getAllMappedBookIds(Long userId);

    public abstract List<Long> getAllMappedUserIds(Long bookId);

}