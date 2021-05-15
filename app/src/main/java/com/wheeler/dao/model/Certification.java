package com.wheeler.dao.model;

import com.wheeler.dao.constant.CertificationLevel;
import com.wheeler.dao.constant.CertificationVendor;
import com.wheeler.dao.model.partial.MonthYear;
import lombok.Data;

@Data
public class Certification {

    private String id;
    private String name;
    private String credential;
    private String description;
    private MonthYear expiry;
    private MonthYear issued;
    private CertificationLevel level;
    private CertificationVendor vendor;
}