package com.wheeler.core.dao.repository;

import java.util.List;

public interface ModelRepository<T> {

    void delete(final T record);

    List<T> findAll();

    void load(final String json);

    void save(final T record);
}
