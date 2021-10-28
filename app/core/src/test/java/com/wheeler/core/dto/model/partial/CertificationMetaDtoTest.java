package com.wheeler.core.dto.model.partial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CertificationMetaDtoTest {

    @Test
    public void construct(){
        final CertificationMetaDto instance = getInstance();
        Assertions.assertEquals(EnumDtoTest.getInstanceList(), instance.getLevels());
        Assertions.assertEquals(EnumDtoTest.getInstanceList(), instance.getVendors());
    }

    public static CertificationMetaDto getInstance(){
        final CertificationMetaDto instance = new CertificationMetaDto();
        instance.setLevels(EnumDtoTest.getInstanceList());
        instance.setVendors(EnumDtoTest.getInstanceList());
        return instance;
    }
}
