package com.wheeler.core.dto.model;

import com.wheeler.core.dao.model.Education;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EducationDto {

    private List<Education> data;
}
