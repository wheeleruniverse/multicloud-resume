package com.wheeler.core.dao.constant;

import com.wheeler.core.dao.constant.helper.EnumDtoMappableImplTest;
import com.wheeler.core.dto.model.partial.EnumDto;
import com.wheeler.core.utility.RandomUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;


public class SkillLevelTest extends EnumDtoMappableImplTest<SkillLevel> {

    @Override
    public Class<SkillLevel> getDaoClass() {
        return SkillLevel.class;
    }

    @Override
    public SkillLevel[] getDaoValues() {
        return SkillLevel.values();
    }

    @Override
    public List<EnumDto> getDtoValues() {
        return SkillLevel.dto();
    }
}
