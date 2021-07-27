package com.wheeler.dao.constant;

import com.wheeler.dto.model.partial.EnumDto;
import com.wheeler.dto.model.partial.EnumDtoMappable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CertificationVendor implements EnumDtoMappable {

    AWS("Amazon Web Services (AWS)"),
    AZURE("Microsoft Azure"),
    GCP("Google Cloud Platform (GCP)"),
    ORACLE("Oracle"),
    SAFE("Scaled Agile Framework");

    private final String display;

    CertificationVendor(final String display) {
        this.display = display;
    }

    @Override
    public String getDisplay() {
        return display;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public Integer getRank() {
        return null;
    }

    public static List<EnumDto> dto(){
        return Arrays.stream(CertificationVendor.values()).map(EnumDto::new).collect(Collectors.toList());
    }
}
