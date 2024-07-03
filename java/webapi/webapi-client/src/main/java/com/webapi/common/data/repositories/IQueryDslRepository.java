package com.webapi.common.data.repositories;

public interface IQueryDslRepository<T> {
    void save(T entity);

    void update(T entity);
}
