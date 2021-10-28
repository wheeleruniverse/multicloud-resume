package com.wheeler.core.dto.model;

import com.wheeler.core.dao.model.Count;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountDto {

    private String name;
    private Integer value;

    public CountDto(final Count data) {
        this.name = data.getName();
        this.value = data.getValue();
    }
}
