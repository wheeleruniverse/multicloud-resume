package com.wheeler.core.dao.repository;

import java.util.List;

public interface CoreRepository<T> {

    int count();

    List<T> findAll();

    void save(T record);
}
