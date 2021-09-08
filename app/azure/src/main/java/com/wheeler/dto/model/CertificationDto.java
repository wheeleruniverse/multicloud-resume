package com.wheeler.dto.model;

import com.wheeler.dao.constant.CertificationLevel;
import com.wheeler.dao.constant.CertificationVendor;
import com.wheeler.dao.model.Certification;
import com.wheeler.dto.model.partial.CertificationMetaDto;
import com.wheeler.dto.model.partial.EnumDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class CertificationDto {

    private List<Certification> data;
    private CertificationMetaDto meta;

    public CertificationDto(final List<Certification> data){
        this.data = data;
        this.meta = new CertificationMetaDto(CertificationLevel.dto(), CertificationVendor.dto());
    }
}
