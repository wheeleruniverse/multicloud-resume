package com.wheeler.dao.model;

import com.wheeler.dao.constant.ExperienceType;
import lombok.Data;

@Data
public class Experience {

    private String id;
    private String name;
    private String description;
    private MonthYear end;
    private Location location;
    private String project;
    private String role;
    private MonthYear start;
    private String title;
    private ExperienceType type;
}