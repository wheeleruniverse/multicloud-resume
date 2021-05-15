package com.wheeler.dao.constant;

import com.wheeler.dto.model.partial.EnumDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CertificationVendor {

    AWS("Amazon Web Services (AWS)"),
    AZURE("Microsoft Azure"),
    GCP("Google Cloud Platform (GCP)"),
    ORACLE("Oracle"),
    SAFE("Scaled Agile Framework");

    private final String display;

    CertificationVendor(final String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }

    public static List<EnumDto> dto(){
        return Arrays.stream(CertificationVendor.values())
                .map(EnumDto::new)
                .collect(Collectors.toList());
    }
}
