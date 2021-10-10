package com.wheeler.core.dao.constant;

import com.wheeler.core.dao.constant.helper.EnumDtoMappableImplTest;
import com.wheeler.core.dto.model.partial.EnumDto;
import com.wheeler.core.utility.RandomUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


public class CertificationVendorTest extends EnumDtoMappableImplTest<CertificationVendor> {

    @Override
    public Class<CertificationVendor> getDaoClass() {
        return CertificationVendor.class;
    }

    @Override
    public CertificationVendor[] getDaoValues() {
        return CertificationVendor.values();
    }

    @Override
    public List<EnumDto> getDtoValues() {
        return CertificationVendor.dto();
    }

    @Test
    @Override
    public void getDescription(){
        assertNull(
                RandomUtil.getEnum(getDaoClass()).getDescription(),
                "CertificationVendor#getDescription should return null"
        );
    }

    @Test
    @Override
    public void getRank(){
        assertNull(
                RandomUtil.getEnum(getDaoClass()).getRank(),
                "CertificationVendor#getRank should return null"
        );
    }
}
