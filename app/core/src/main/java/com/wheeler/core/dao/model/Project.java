package com.wheeler.core.dao.model;

import com.wheeler.core.dao.model.partial.MonthYear;
import lombok.Data;

@Data
public class Project {

    private String id;
    private String name;
    private String blog;
    private String code;
    private String description;
    private MonthYear end;
    private String[] skills;
    private MonthYear start;
    private String website;
}