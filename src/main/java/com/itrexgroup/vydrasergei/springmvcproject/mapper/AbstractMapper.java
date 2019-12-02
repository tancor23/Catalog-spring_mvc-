package com.itrexgroup.vydrasergei.springmvcproject.mapper;

import java.util.Collection;
import java.util.List;

public interface AbstractMapper<D,T> {

    D mapToDto(final T entity);

    T mapToEntity(final D dto);

    List<D> mapAllToDto(final Collection<T> entityList);

    List<T> mapAllToEntity(final Collection<D> dtoList);
}
