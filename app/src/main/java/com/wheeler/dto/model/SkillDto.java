package com.wheeler.dto.model;

import com.wheeler.dao.model.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SkillDto {

    private List<SkillLevelDto> levels;
    private List<Skill> skills;
}
