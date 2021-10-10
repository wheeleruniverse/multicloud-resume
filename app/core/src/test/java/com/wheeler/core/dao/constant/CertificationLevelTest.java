package com.wheeler.core.dao.constant;

import com.wheeler.core.dao.constant.helper.EnumDtoMappableImplTest;
import com.wheeler.core.dto.model.partial.EnumDto;

import java.util.List;


public class CertificationLevelTest extends EnumDtoMappableImplTest<CertificationLevel> {

    @Override
    public Class<CertificationLevel> getDaoClass() {
        return CertificationLevel.class;
    }

    @Override
    public CertificationLevel[] getDaoValues() {
        return CertificationLevel.values();
    }

    @Override
    public List<EnumDto> getDtoValues() {
        return CertificationLevel.dto();
    }
}
