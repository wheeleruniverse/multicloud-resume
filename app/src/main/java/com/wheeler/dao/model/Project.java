package com.wheeler.dao.model;

import com.wheeler.dao.model.partial.MonthYear;
import lombok.Data;

@Data
public class Project {

    private String id;
    private String name;
    private String blog;
    private String code;
    private String description;
    private MonthYear end;
    private MonthYear start;
    private String website;
}