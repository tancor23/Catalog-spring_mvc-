package com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.impl;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.AbstractDao;
import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.UserBookDao;
import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.UserDao;
import com.itrexgroup.vydrasergei.springmvcproject.entity.UserBookEntity;
import com.itrexgroup.vydrasergei.springmvcproject.entity.UserBookPKEntity;
import com.itrexgroup.vydrasergei.springmvcproject.entity.UserEntity;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserBookDaoImpl extends AbstractDao implements UserBookDao {

    @Override
    public UserBookEntity create(UserBookEntity userBookEntity) {
        getSession().save(userBookEntity);
        return userBookEntity;
    }

    @Override
    public UserBookEntity findByIds(Long userId, Long bookId) {
        return getSession().get(UserBookEntity.class, new UserBookPKEntity(userId, bookId));
    }

    @Override
    public void delete(UserBookEntity userBookEntity) {
        getSession().delete(userBookEntity);
    }

    @Override
    public boolean isExist(Long userId, Long bookId) {
        Query query = getSession().createQuery("FROM UserBookEntity WHERE userBookPKEntity.userId=:userId and userBookPKEntity.bookId =:bookId");
        query.setParameter("userId", userId);
        query.setParameter("bookId", bookId);
        List list = query.list();
        return list.size() > 0;
    }
}

