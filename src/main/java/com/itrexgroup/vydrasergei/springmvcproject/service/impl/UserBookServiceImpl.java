package com.itrexgroup.vydrasergei.springmvcproject.service.impl;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.UserBookDao;
import com.itrexgroup.vydrasergei.springmvcproject.entity.UserBookEntity;
import com.itrexgroup.vydrasergei.springmvcproject.entity.UserBookPKEntity;
import com.itrexgroup.vydrasergei.springmvcproject.service.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBookServiceImpl implements UserBookService {

    private final UserBookDao userBookDao;

    @Autowired
    public UserBookServiceImpl(UserBookDao userBookDao) {
        this.userBookDao = userBookDao;
    }

    @Override
    public UserBookEntity create(UserBookEntity userBookEntity) {
        return userBookDao.create(userBookEntity);
    }

    @Override
    public UserBookEntity create(Long user_id, Long book_id) {
        UserBookEntity userBookEntity = new UserBookEntity(new UserBookPKEntity(user_id, book_id));
        return create(userBookEntity);
    }

    @Override
    public UserBookEntity getByIDs(Long user_id, Long book_id) {
        return userBookDao.findByIds(user_id, book_id);
    }

    @Override
    public void delete(UserBookEntity userBookEntity) {
        userBookDao.delete(userBookEntity);
    }

    @Override
    public void delete(Long user_id, Long book_id) {
        UserBookEntity userBookEntity = new UserBookEntity(new UserBookPKEntity(user_id, book_id));
        delete(userBookEntity);
    }

}
