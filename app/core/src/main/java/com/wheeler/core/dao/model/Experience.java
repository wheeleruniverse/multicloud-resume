package com.wheeler.core.dao.model;

import com.wheeler.core.dao.constant.ExperienceType;
import com.wheeler.core.dao.model.contract.Model;
import com.wheeler.core.dao.model.partial.Location;
import com.wheeler.core.dao.model.partial.MonthYear;
import lombok.Data;

import java.util.List;

@Data
public class Experience implements Model {

    private String id;
    private String name;
    private List<String> descriptions;
    private MonthYear end;
    private Location location;
    private String project;
    private String role;
    private MonthYear start;
    private String title;
    private ExperienceType type;

    public static String getTableName() {
        return "experience";
    }
}