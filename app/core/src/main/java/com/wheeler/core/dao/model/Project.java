package com.wheeler.core.dao.model;

import com.wheeler.core.dao.model.contract.Entity;
import com.wheeler.core.dao.model.partial.MonthYear;
import lombok.Data;

import java.util.List;

@Data
public class Project implements Entity {

    private String id;
    private String name;
    private String blog;
    private String code;
    private String description;
    private MonthYear end;
    private List<String> skills;
    private MonthYear start;
    private String website;
}