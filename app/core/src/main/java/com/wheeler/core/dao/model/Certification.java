package com.wheeler.core.dao.model;

import com.wheeler.core.dao.constant.CertificationLevel;
import com.wheeler.core.dao.constant.CertificationVendor;
import com.wheeler.core.dao.model.contract.Model;
import com.wheeler.core.dao.model.partial.MonthYear;
import com.wheeler.core.dto.model.CertificationDto;
import lombok.Data;

import java.util.List;

@Data
public class Certification implements Model {

    private String id;
    private String name;
    private String credential;
    private List<String> descriptions;
    private MonthYear expiry;
    private MonthYear issued;
    private CertificationLevel level;
    private CertificationVendor vendor;

    public static String getTableName() {
        return "certification";
    }
}
