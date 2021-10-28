package com.wheeler.core.dao.constant;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExperienceTypeTest {

    @Test
    public void values(){
        final Set<ExperienceType> allValues = Sets.newHashSet(
                ExperienceType.CONTRACT,
                ExperienceType.FULLTIME
        );
        Arrays.stream(ExperienceType.values()).forEach(type ->
            assertTrue(allValues.contains(type), "'type' should be within 'allValues'")
        );
    }
}
