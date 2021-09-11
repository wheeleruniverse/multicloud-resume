package com.wheeler.core.dao.model;

import com.wheeler.core.dao.constant.SkillLevel;
import lombok.Data;

@Data
public class Skill {

    private String id;
    private String name;
    private SkillLevel level;
    private String[] projects;
    private String type;
}