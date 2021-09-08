package com.wheeler.dto.model.partial;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CertificationMetaDto {

    private List<EnumDto> levels;
    private List<EnumDto> vendors;
}
