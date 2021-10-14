package com.wheeler.core.dao.model;

import com.wheeler.core.dao.constant.CertificationLevel;
import com.wheeler.core.dao.constant.CertificationVendor;
import com.wheeler.core.dao.model.contract.Model;
import com.wheeler.core.dao.model.partial.MonthYear;
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

    /**
     * Sets the CertificationLevel with a String instead of an enumerator.
     * @param level the CertificationLevel value as a String.
     */
    public void setLevel(final String level) {
        if (level != null) {
            this.level = CertificationLevel.valueOf(level);
        }
    }

    /**
     * Sets the CertificationVendor with a String instead of an enumerator.
     * @param vendor the CertificationVendor value as a String.
     */
    public void setVendor(final String vendor){
        if (vendor != null) {
            this.vendor = CertificationVendor.valueOf(vendor);
        }
    }
}
