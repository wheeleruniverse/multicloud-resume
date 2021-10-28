package com.wheeler.core.dto.model.partial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillMetaDto {

    private List<EnumDto> levels;
}
