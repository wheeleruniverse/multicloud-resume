package com.wheeler.dto.model;

import com.wheeler.dao.model.Project;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProjectDto {

    private List<Project> data;
}
