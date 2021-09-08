package com.wheeler.core.dto.model;

import com.wheeler.core.dao.model.Project;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProjectDto {

    private List<Project> data;
}
