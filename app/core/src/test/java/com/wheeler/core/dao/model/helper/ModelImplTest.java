package com.wheeler.core.dao.model.helper;

import com.wheeler.core.dao.model.contract.Model;
import com.wheeler.core.utility.RandomUtil;
import com.wheeler.core.utility.ReflectUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class ModelImplTest<T extends Model> {

    public abstract Class<T> getDaoClass();

    @Test
    public void getId() {
        final String id = RandomUtil.getString();
        final T instance = ReflectUtil.construct(getDaoClass());
        instance.setId(id);
        assertEquals(id, instance.getId());
    }
}
