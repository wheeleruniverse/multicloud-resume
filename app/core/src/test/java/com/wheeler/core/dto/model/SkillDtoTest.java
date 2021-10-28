package com.wheeler.core.dto.model;

import com.wheeler.core.dao.constant.SkillLevel;
import com.wheeler.core.dao.model.SkillTest;
import com.wheeler.core.dto.model.partial.SkillMetaDto;
import com.wheeler.core.dto.model.partial.SkillMetaDtoTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SkillDtoTest {

    @Test
    public void construct(){
        final SkillDto instance = getInstance();
        Assertions.assertEquals(SkillTest.getInstanceList(), instance.getData());
        Assertions.assertEquals(SkillMetaDtoTest.getInstance(), instance.getMeta());
    }

    @Test
    public void constructWithSkillList(){
        final SkillDto instance = new SkillDto(SkillTest.getInstanceList());
        Assertions.assertEquals(SkillTest.getInstanceList(), instance.getData());
        Assertions.assertEquals(new SkillMetaDto(SkillLevel.dto()), instance.getMeta());
    }

    public static SkillDto getInstance(){
        final SkillDto instance = new SkillDto();
        instance.setData(SkillTest.getInstanceList());
        instance.setMeta(SkillMetaDtoTest.getInstance());
        return instance;
    }
}
