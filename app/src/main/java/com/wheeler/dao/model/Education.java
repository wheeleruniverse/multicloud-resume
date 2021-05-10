package com.wheeler.dao.model;

import lombok.Data;

import java.time.LocalDate;

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