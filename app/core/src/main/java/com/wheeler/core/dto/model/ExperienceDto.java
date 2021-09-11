package com.wheeler.core.dto.model;

import com.wheeler.core.dao.model.Experience;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ExperienceDto {

    private List<Experience> data;
}
