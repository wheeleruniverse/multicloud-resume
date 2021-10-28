package com.wheeler.core.dto.model;

import com.wheeler.core.dao.constant.CertificationLevel;
import com.wheeler.core.dao.constant.CertificationVendor;
import com.wheeler.core.dao.model.CertificationTest;
import com.wheeler.core.dto.model.partial.CertificationMetaDto;
import com.wheeler.core.dto.model.partial.CertificationMetaDtoTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CertificationDtoTest {

    @Test
    public void construct(){
        final CertificationDto instance = getInstance();
        Assertions.assertEquals(CertificationTest.getInstanceList(), instance.getData());
        Assertions.assertEquals(CertificationMetaDtoTest.getInstance(), instance.getMeta());
    }

    @Test
    public void constructWithCertificationList(){
        final CertificationDto instance = new CertificationDto(CertificationTest.getInstanceList());
        Assertions.assertEquals(CertificationTest.getInstanceList(), instance.getData());
        Assertions.assertEquals(
            new CertificationMetaDto(CertificationLevel.dto(), CertificationVendor.dto()),
            instance.getMeta()
        );
    }

    public static CertificationDto getInstance(){
        final CertificationDto instance = new CertificationDto();
        instance.setData(CertificationTest.getInstanceList());
        instance.setMeta(CertificationMetaDtoTest.getInstance());
        return instance;
    }
}
