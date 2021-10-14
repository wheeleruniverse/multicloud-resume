package com.wheeler.core.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldDto {

    private final String name;
    private final Class<?> type;
    private final Object value;
}
