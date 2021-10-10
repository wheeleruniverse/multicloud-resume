package com.wheeler.core.dao.model.helper;

import com.wheeler.core.dao.model.contract.Model;
import com.wheeler.core.dto.model.partial.EnumDto;
import com.wheeler.core.dto.model.partial.EnumDtoMappable;
import com.wheeler.core.utility.RandomUtil;
import com.wheeler.core.utility.model.RandomStringOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public abstract class ModelImplTest<T extends Model> {

    public abstract Class<T> getDaoClass();

    @Test
    public void getId() {
        final String id = RandomUtil.getString();
        final T instance = getInstance();
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    private T getInstance(){
        try {
            return getDaoClass().getConstructor().newInstance();
        }
        catch (IllegalAccessException
                | InstantiationException
                | InvocationTargetException
                | NoSuchMethodException e
        ) {
            throw new IllegalStateException(String.format("exception occurred %s", e));
        }
    }
}
