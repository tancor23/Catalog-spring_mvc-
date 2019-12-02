package com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.impl;

import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.AbstractDao;
import com.itrexgroup.vydrasergei.springmvcproject.dao.mysql.UserDao;
import com.itrexgroup.vydrasergei.springmvcproject.entity.UserEntity;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImpl extends AbstractDao implements UserDao {

    @Override
    public UserEntity create(UserEntity userEntity) {
        getSession().save(userEntity);
        return userEntity;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<UserEntity> query = builder.createQuery(UserEntity.class);
        Root<UserEntity> root = query.from(UserEntity.class);
        query.select(root);
        Query<UserEntity> q = getSession().createQuery(query);
        return q.getResultList();
    }

    @Override
    public void update(UserEntity userEntity) {
        getSession().update(userEntity);
    }

    @Override
    public UserEntity getById(Long key) {
        return getSession().get(UserEntity.class, key);
    }

    @Override
    public void persist(UserEntity entity) {
        getSession().persist(entity);
    }

    @Override
    public void delete(UserEntity entity) {
        getSession().delete(entity);
    }
}
