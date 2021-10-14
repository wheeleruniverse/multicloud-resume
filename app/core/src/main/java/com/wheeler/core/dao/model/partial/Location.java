package com.wheeler.core.dao.model.partial;

import lombok.Data;

@Data
public class Location {

    private String address;
    private String city;
    private Boolean remote;
    private String state;
    private String zip;
}
