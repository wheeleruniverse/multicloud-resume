package com.wheeler.core.dao.model;

import com.wheeler.core.dao.model.helper.ModelImplTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CertificationTest extends ModelImplTest<Certification> {

    @Override
    public Class<Certification> getDaoClass() {
        return Certification.class;
    }

    @Test
    public void getTableName(){
        final String expected = Certification.class.getSimpleName().toLowerCase();
        assertEquals(expected, Certification.getTableName());
    }
}
