package com.itrexgroup.vydrasergei.springmvcproject.dao;

import java.util.List;

public abstract class GenericDAO<O, K> {

    public abstract boolean create(O entity);

    public abstract O findById(K id);

    public abstract List<O> findAll();

    public abstract boolean update(O entity);

    public abstract boolean delete(K id);
}
