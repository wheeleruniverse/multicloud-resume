package com.wheeler.dto.model;

import com.wheeler.dao.constant.SkillLevel;
import com.wheeler.dao.model.Skill;
import com.wheeler.dto.model.partial.SkillMetaDto;
import lombok.Data;

import java.util.List;

@Data
public class SkillDto {

    private List<Skill> data;
    private SkillMetaDto meta;

    public SkillDto(final List<Skill> data) {
        this.data = data;
        this.meta = new SkillMetaDto(SkillLevel.dto());
    }
}
