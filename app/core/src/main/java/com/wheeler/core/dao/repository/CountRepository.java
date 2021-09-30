package com.wheeler.core.dao.repository;

import com.wheeler.core.dao.model.Count;


public interface CountRepository {

    Count count();

    void increment();

    void load(final Integer value);
}
