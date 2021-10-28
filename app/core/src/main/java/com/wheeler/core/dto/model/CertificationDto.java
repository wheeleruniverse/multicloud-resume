package com.wheeler.core.dto.model;

import com.wheeler.core.dao.constant.CertificationLevel;
import com.wheeler.core.dao.constant.CertificationVendor;
import com.wheeler.core.dao.model.Certification;
import com.wheeler.core.dto.model.partial.CertificationMetaDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CertificationDto {

    private List<Certification> data;
    private CertificationMetaDto meta;

    public CertificationDto(final List<Certification> data){
        this.data = data;
        this.meta = new CertificationMetaDto(CertificationLevel.dto(), CertificationVendor.dto());
    }
}
