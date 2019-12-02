package com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.impl;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.AbstractDao;
import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.BookDao;
import com.itrexgroup.vydrasergei.springmvcproject.entity.BookEntity;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BookDaoImpl extends AbstractDao implements BookDao {

    @Override
    public boolean create(BookEntity bookEntity) {
        getSession().save(bookEntity);
        return true;
    }

    @Override
    public List<BookEntity> getAllBooks() {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<BookEntity> query = builder.createQuery(BookEntity.class);
        Root<BookEntity> root = query.from(BookEntity.class);
        query.select(root);
        Query<BookEntity> q = getSession().createQuery(query);
        return q.getResultList();
    }

    @Override
    public void update(BookEntity bookEntity) {
        getSession().update(bookEntity);
    }

    @Override
    public BookEntity getById(Long key) {
        return getSession().get(BookEntity.class, key);
    }

    @Override
    public void persist(BookEntity entity) {
        getSession().persist(entity);
    }

    @Override
    public void delete(BookEntity entity) {
        getSession().delete(entity);
    }
}
