package com.wheeler.dto.model.partial;

import com.wheeler.dao.constant.CertificationLevel;
import com.wheeler.dao.constant.CertificationVendor;
import com.wheeler.dao.constant.SkillLevel;
import lombok.Data;


@Data
public class EnumDto {

    private String name;
    private String description;
    private String display;
    private Integer rank;

    public EnumDto(final CertificationLevel value) {
        this.name = value.name();
        this.description = value.getDescription();
        this.display = value.getDisplay();
        this.rank = value.getRank();
    }

    public EnumDto(final CertificationVendor value) {
        this.name = value.name();
        this.display = value.getDisplay();
    }

    public EnumDto(final SkillLevel value) {
        this.name = value.name();
        this.description = value.getDescription();
        this.display = value.getDisplay();
        this.rank = value.getRank();
    }
}
