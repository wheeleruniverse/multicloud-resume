package com.wheeler.core.dto.model;

import com.wheeler.core.dao.constant.SkillLevel;
import com.wheeler.core.dao.model.Skill;
import com.wheeler.core.dto.model.partial.SkillMetaDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SkillDto {

    private List<Skill> data;
    private SkillMetaDto meta;

    public SkillDto(final List<Skill> data) {
        this.data = data;
        this.meta = new SkillMetaDto(SkillLevel.dto());
    }
}
