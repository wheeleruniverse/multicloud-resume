package com.wheeler.core.dto.model.helper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Argument<T> {

    private final String name;
    private final T value;
}
