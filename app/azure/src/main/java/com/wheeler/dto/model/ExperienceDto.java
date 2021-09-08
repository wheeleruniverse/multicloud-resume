package com.wheeler.dto.model;

import com.wheeler.dao.model.Experience;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ExperienceDto {

    private List<Experience> data;
}
