package com.wheeler.core.dao.model;

import com.wheeler.core.dao.constant.ExperienceType;
import com.wheeler.core.dao.model.partial.Location;
import com.wheeler.core.dao.model.partial.MonthYear;
import lombok.Data;

@Data
public class Experience {

    private String id;
    private String name;
    private String[] descriptions;
    private MonthYear end;
    private Location location;
    private String project;
    private String role;
    private MonthYear start;
    private String title;
    private ExperienceType type;
}