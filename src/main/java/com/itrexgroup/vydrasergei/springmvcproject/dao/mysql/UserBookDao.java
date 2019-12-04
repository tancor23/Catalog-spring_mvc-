package com.itrexgroup.vydrasergei.springmvcproject.dao.mysql;

import com.itrexgroup.vydrasergei.springmvcproject.entity.UserBookEntity;

public interface UserBookDao {

    UserBookEntity create(UserBookEntity userBookEntity);

    UserBookEntity findByIds(Long userId, Long bookId);

    void delete(UserBookEntity userBookEntity);

    boolean isExist(Long userId, Long bookId);
}