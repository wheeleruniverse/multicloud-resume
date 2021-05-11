package com.wheeler.dao.model;

import com.wheeler.dao.model.partial.Location;
import lombok.Data;

@Data
public class Education {

    private String id;
    private String name;
    private String degree;
    private String description;
    private Integer endYear;
    private String field;
    private Location location;
    private Integer startYear;
}