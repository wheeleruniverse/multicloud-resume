package com.wheeler.dto.model;

import com.wheeler.dao.constant.SkillLevel;
import lombok.Data;


@Data
public class SkillLevelDto {

    private String name;
    private String description;
    private int rank;

    public SkillLevelDto(SkillLevel level){
        this.name = level.name();
        this.description = level.getDescription();
        this.rank = level.getRank();
    }
}
