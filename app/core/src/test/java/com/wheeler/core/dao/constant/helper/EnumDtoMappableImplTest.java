package com.wheeler.core.dao.constant.helper;

import com.wheeler.core.dto.model.partial.EnumDto;
import com.wheeler.core.dto.model.partial.EnumDtoMappable;
import com.wheeler.core.utility.RandomUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public abstract class EnumDtoMappableImplTest<T extends Enum<T> & EnumDtoMappable> {

    public abstract Class<T> getDaoClass();

    public abstract T[] getDaoValues();

    public abstract List<EnumDto> getDtoValues();

    @Test
    public void dto(){
        final T[] daoValues = getDaoValues();
        final List<EnumDto> dtoValues = getDtoValues();
        assertEquals(daoValues.length, dtoValues.size());

        Arrays.stream(daoValues).forEach(dao -> {
            final EnumDto dto = dtoValues.stream()
                    .filter(val -> dao.name().equals(val.getName()))
                    .findFirst().orElseThrow(IllegalStateException::new);

            assertEquals(dao.getDescription(), dto.getDescription());
            assertEquals(dao.getDisplay(), dto.getDisplay());
            assertEquals(dao.getRank(), dto.getRank());
        });
    }

    @Test
    public void getDescription(){
        final Class<T> daoClass = getDaoClass();
        assertNotNull(
                RandomUtil.getEnum(daoClass).getDescription(),
                String.format("%s#getDescription should not return null", daoClass.getSimpleName())
        );
    }

    @Test
    public void getDisplay(){
        final Class<T> daoClass = getDaoClass();
        assertNotNull(
            RandomUtil.getEnum(daoClass).getDisplay(),
            String.format("%s#getDisplay should not return null", daoClass.getSimpleName())
        );
    }

    @Test
    public void getRank(){
        final Class<T> daoClass = getDaoClass();
        assertNotNull(
            RandomUtil.getEnum(daoClass).getRank(),
            String.format("%s#getRank should not return null", daoClass.getSimpleName())
        );
    }

    @Test
    public void implementsEnumDtoMappable(){
        final Class<T> daoClass = getDaoClass();
        Assertions.assertTrue(
            EnumDtoMappable.class.isAssignableFrom(daoClass),
            String.format("%s should implement EnumDtoMappable", daoClass.getSimpleName())
        );
    }
}
