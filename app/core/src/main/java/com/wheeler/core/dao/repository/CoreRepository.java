package com.wheeler.core.dao.repository;

import java.util.List;

public interface CoreRepository<T> {

    int count();

    List<T> findAll();

    void load(final String json);

    void save(final T record);
}
