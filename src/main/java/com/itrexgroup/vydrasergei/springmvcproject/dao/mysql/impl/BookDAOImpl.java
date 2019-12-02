package com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.impl;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.AbstractDAO;
import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.BookDAO;
import com.itrexgroup.vydrasergei.springmvcproject.domain.mysql.Book;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BookDAOImpl extends AbstractDAO implements BookDAO {

    @Override
    public boolean create(Book book) {
        getSession().save(book);
        return true;
    }

    @Override
    public List<Book> getAllBooks() {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<Book> query = builder.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        query.select(root);
        Query<Book> q = getSession().createQuery(query);
        return q.getResultList();
    }

    @Override
    public void update(Book book) {
        getSession().update(book);
    }

    @Override
    public Book getById(Long key) {
        return getSession().get(Book.class, key);
    }

    @Override
    public void persist(Book entity) {
        getSession().persist(entity);
    }

    @Override
    public void delete(Book entity) {
        getSession().delete(entity);
    }
}
