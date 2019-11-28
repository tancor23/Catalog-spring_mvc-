package com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.impl;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.BookDAO;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.Book;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean create(Book book) {
        sessionFactory.getCurrentSession().save(book);
        return true;
    }

    @Override
    public List<Book> getAllBooks() {
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Book> query = builder.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        query.select(root);
        Query<Book> q = sessionFactory.getCurrentSession().createQuery(query);
        return q.getResultList();
    }

    @Override
    public Book getBookByID(Long id) {
        return sessionFactory.getCurrentSession().get(Book.class, id);
    }

    @Override
    public void delete(Book book) {
        sessionFactory.getCurrentSession().delete(book);
    }

    @Override
    public void update(Book book) {
        sessionFactory.getCurrentSession().update(book);
    }

}
