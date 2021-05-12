package com.wheeler.dao.constant;

import com.wheeler.dto.model.SkillLevelDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SkillLevel {

    COMPETENT(2, "used on at least one project with a solid understanding of configuration options"),
    EXPERT(4, "used on multiple projects with various configurations and optimizations"),
    MASTER(5, "used on multiple formal enterprise projects with various configurations and optimizations in a highly regulated environment"),
    NOVICE(1, "used on at least one project with a basic understanding of configuration options"),
    PROFICIENT(3, "used on multiple projects with a strong knowledge of configuration and optimization options");

    private final String description;
    private final int rank;

    SkillLevel(final int rank, final String description) {
        this.rank = rank;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getRank() {
        return rank;
    }

    public static List<SkillLevelDto> getValues(){
        return Arrays.stream(SkillLevel.values())
                .map(SkillLevelDto::new)
                .collect(Collectors.toList());
    }
}
