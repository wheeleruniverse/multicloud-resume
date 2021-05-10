package com.wheeler.dao.model;

import lombok.Data;

@Data
public class Location {

    private String address;
    private String city;
    private boolean remote;
    private String state;
    private String zip;
}
