package com.wheeler.core.dao.model;

import com.wheeler.core.dao.model.helper.ModelImplTest;
import com.wheeler.core.dao.model.partial.Location;
import com.wheeler.core.dao.model.partial.LocationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EducationTest extends ModelImplTest<Education> {

    @Override
    public Class<Education> getDaoClass() {
        return Education.class;
    }

    @Test
    public void construct(){
        final Education instance = getInstance();
        Assertions.assertEquals("id", instance.getId());
        Assertions.assertEquals("name", instance.getName());
        Assertions.assertEquals("degree", instance.getDegree());
        Assertions.assertEquals(asList("description0", "description1"), instance.getDescriptions());
        Assertions.assertEquals(2022, instance.getEnd());
        Assertions.assertEquals("field", instance.getField());
        Assertions.assertEquals(LocationTest.getInstance(), instance.getLocation());
        Assertions.assertEquals(2021, instance.getStart());
    }

    @Test
    public void getTableName(){
        final String expected = Education.class.getSimpleName().toLowerCase();
        assertEquals(expected, Education.getTableName());
    }

    public static Education getInstance(){
        final Education instance = new Education();
        instance.setId("id");
        instance.setName("name");
        instance.setDegree("degree");
        instance.setDescriptions(asList("description0", "description1"));
        instance.setEnd(2022);
        instance.setField("field");
        instance.setLocation(LocationTest.getInstance());
        instance.setStart(2021);
        return instance;
    }

    public static List<Education> getInstanceList(){
        return singletonList(getInstance());
    }
}
