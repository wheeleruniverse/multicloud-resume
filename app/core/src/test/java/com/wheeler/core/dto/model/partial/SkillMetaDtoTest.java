package com.wheeler.core.dto.model.partial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.singletonList;

public class SkillMetaDtoTest {

    @Test
    public void construct(){
        final SkillMetaDto instance = getInstance();
        Assertions.assertEquals(EnumDtoTest.getInstanceList(), instance.getLevels());
    }

    public static SkillMetaDto getInstance(){
        final SkillMetaDto instance = new SkillMetaDto();
        instance.setLevels(EnumDtoTest.getInstanceList());
        return instance;
    }
}
