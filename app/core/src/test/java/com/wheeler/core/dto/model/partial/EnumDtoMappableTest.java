package com.wheeler.core.dto.model.partial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnumDtoMappableTest {

    @Test
    public void construct(){
        final EnumDtoMappable instance = getEnumDtoMappable();
        Assertions.assertEquals("name", instance.name());
        Assertions.assertEquals("description", instance.getDescription());
        Assertions.assertEquals("display", instance.getDisplay());
        Assertions.assertEquals(1, instance.getRank());
    }

    private EnumDtoMappable getEnumDtoMappable(){
        return new EnumDtoMappable() {
            @Override
            public String name() {
                return "name";
            }

            @Override
            public String getDescription() {
                return "description";
            }

            @Override
            public String getDisplay() {
                return "display";
            }

            @Override
            public Integer getRank() {
                return 1;
            }
        };
    }
}
