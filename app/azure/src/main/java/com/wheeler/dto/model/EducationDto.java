package com.wheeler.dto.model;

import com.wheeler.dao.model.Education;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EducationDto {

    private List<Education> data;
}
