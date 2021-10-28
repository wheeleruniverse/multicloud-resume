package com.wheeler.core.dao.model;

import com.wheeler.core.dao.constant.CertificationLevel;
import com.wheeler.core.dao.constant.CertificationVendor;
import com.wheeler.core.dao.model.helper.ModelImplTest;
import com.wheeler.core.dao.model.partial.MonthYearTest;
import com.wheeler.core.dto.model.partial.EnumDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CertificationTest extends ModelImplTest<Certification> {

    @Override
    public Class<Certification> getDaoClass() {
        return Certification.class;
    }

    @Test
    public void construct(){
        final Certification instance = getInstance();
        Assertions.assertEquals("id", instance.getId());
        Assertions.assertEquals("name", instance.getName());
        Assertions.assertEquals("credential", instance.getCredential());
        Assertions.assertEquals(asList("description0", "description1"), instance.getDescriptions());
        Assertions.assertEquals(MonthYearTest.getInstance(), instance.getExpiry());
        Assertions.assertEquals(MonthYearTest.getInstance(), instance.getIssued());
        Assertions.assertEquals(CertificationLevel.ASSOCIATE, instance.getLevel());
        Assertions.assertEquals(CertificationVendor.AWS, instance.getVendor());
    }

    @Test
    public void getTableName(){
        final String expected = Certification.class.getSimpleName().toLowerCase();
        assertEquals(expected, Certification.getTableName());
    }

    public static Certification getInstance(){
        final Certification instance = new Certification();
        instance.setId("id");
        instance.setName("name");
        instance.setCredential("credential");
        instance.setDescriptions(asList("description0", "description1"));
        instance.setExpiry(MonthYearTest.getInstance());
        instance.setIssued(MonthYearTest.getInstance());
        instance.setLevel(CertificationLevel.ASSOCIATE);
        instance.setVendor(CertificationVendor.AWS);
        return instance;
    }

    public static List<Certification> getInstanceList(){
        return singletonList(getInstance());
    }
}
