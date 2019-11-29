package com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.impl;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.AbstractDAO;
import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.UserDAO;
import com.itrexgroup.vydrasergei.springmvcproject.domain.util.mysql.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDAOImpl extends AbstractDAO implements UserDAO {

    @Override
    public boolean create(User user) {
        getSession().save(user);
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        Query<User> q = getSession().createQuery(query);
        return q.getResultList();
    }

    @Override
    public void update(User user) {
        getSession().update(user);
    }

    @Override
    public User getById(Long key) {
        return getSession().get(User.class, key);
    }

    @Override
    public void persist(User entity) {
        getSession().persist(entity);
    }

    @Override
    public void delete(User entity) {
        getSession().delete(entity);
    }
}
