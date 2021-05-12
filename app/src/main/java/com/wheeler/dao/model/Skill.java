package com.wheeler.dao.model;

import com.wheeler.dao.constant.SkillLevel;
import lombok.Data;

@Data
public class Skill {

    private String id;
    private String name;
    private SkillLevel level;
    private String type;
}