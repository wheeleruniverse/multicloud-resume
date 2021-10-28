package com.wheeler.core.dto.model.partial;

import com.wheeler.core.dao.constant.CertificationLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.singletonList;

public class EnumDtoTest {

    @Test
    public void construct(){
        final EnumDto instance = getInstance();
        Assertions.assertEquals("name", instance.getName());
        Assertions.assertEquals("description", instance.getDescription());
        Assertions.assertEquals("display", instance.getDisplay());
        Assertions.assertEquals(1, instance.getRank());
    }

    @Test
    public void constructWithEnumDtoMappable(){
        final EnumDto instance = new EnumDto(CertificationLevel.ASSOCIATE);
        Assertions.assertEquals("ASSOCIATE", instance.getName());
        Assertions.assertEquals(
            "one year of experience solving problems and implementing solutions using the aws cloud",
            instance.getDescription()
        );
        Assertions.assertEquals("Associate", instance.getDisplay());
        Assertions.assertEquals(2, instance.getRank());
    }

    public static EnumDto getInstance(){
        final EnumDto instance = new EnumDto();
        instance.setName("name");
        instance.setDescription("description");
        instance.setDisplay("display");
        instance.setRank(1);
        return instance;
    }

    public static List<EnumDto> getInstanceList(){
        return singletonList(getInstance());
    }
}
