package com.wheeler.dao.constant;

import com.wheeler.dto.model.partial.EnumDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SkillLevel {

    COMPETENT(
        "used on at least one project with a solid understanding of configuration options",
        "Competent",
        2
    ),
    EXPERT(
        "used on multiple projects with various configurations and optimizations",
        "Expert",
        4
    ),
    MASTER(
        "used on multiple formal enterprise projects with various configurations and optimizations in a highly regulated environment",
        "Master",
        5
    ),
    NOVICE(
        "used on at least one project with a basic understanding of configuration options",
        "Novice",
        1
    ),
    PROFICIENT(
        "used on multiple projects with a strong knowledge of configuration and optimization options",
        "Proficient",
        3
    );

    private final String description;
    private final String display;
    private final int rank;

    SkillLevel(final String description, final String display, final int rank) {
        this.description = description;
        this.display = display;
        this.rank = rank;
    }

    public String getDescription() {
        return description;
    }

    public String getDisplay() {
        return display;
    }

    public int getRank() {
        return rank;
    }

    public static List<EnumDto> dto(){
        return Arrays.stream(SkillLevel.values())
                .map(EnumDto::new)
                .collect(Collectors.toList());
    }
}
