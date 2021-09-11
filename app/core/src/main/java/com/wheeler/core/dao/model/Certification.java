package com.wheeler.core.dao.model;

import com.wheeler.core.dao.constant.CertificationLevel;
import com.wheeler.core.dao.constant.CertificationVendor;
import com.wheeler.core.dao.model.partial.MonthYear;
import lombok.Data;

@Data
public class Certification {

    private String id;
    private String name;
    private String credential;
    private String[] descriptions;
    private MonthYear expiry;
    private MonthYear issued;
    private CertificationLevel level;
    private CertificationVendor vendor;
}
