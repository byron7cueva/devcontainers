package com.webapi.common.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.support.PageableExecutionUtils;

import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;

public class JPAQueryDslRepository<T> extends QuerydslRepositorySupport implements IQueryDslRepository<T> {

    private final Class<T> domainClass;

    public JPAQueryDslRepository(Class<T> domainClass) {
        super(domainClass);
        this.domainClass = domainClass;
    }

    @Override
    public void save(T entity) {
        this.getEntityManager().persist(entity);
    }

    @Override
    public void update(T entity) {
        this.getEntityManager().merge(entity);
    }

    protected <P> JPQLQuery<P> cloneQuery(JPAQuery<P> query) {
        return query.clone(this.getEntityManager());
    }

    protected <Q> Page<Q> findPageData(JPQLQuery<Q> query, Pageable pageable) {
        JPQLQuery<Q> counQuery = cloneQuery((JPAQuery<Q>) query);
        return PageableExecutionUtils.getPage(getQuerydsl().applyPagination(pageable, query).fetch(), pageable,
                counQuery::fetchCount);
    }
}
