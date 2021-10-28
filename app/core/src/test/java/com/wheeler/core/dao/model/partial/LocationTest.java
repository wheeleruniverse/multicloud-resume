package com.wheeler.core.dao.model.partial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LocationTest {

    @Test
    public void construct(){
        final Location instance = getInstance();
        Assertions.assertEquals("address", instance.getAddress());
        Assertions.assertEquals("city", instance.getCity());
        Assertions.assertEquals(true, instance.getRemote());
        Assertions.assertEquals("state", instance.getState());
        Assertions.assertEquals("zip", instance.getZip());
    }

    public static Location getInstance(){
        final Location instance = new Location();
        instance.setAddress("address");
        instance.setCity("city");
        instance.setRemote(true);
        instance.setState("state");
        instance.setZip("zip");
        return instance;
    }
}
