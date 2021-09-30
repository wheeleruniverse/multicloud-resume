package com.wheeler.core.dao.model;

import com.wheeler.core.dao.model.contract.Model;
import com.wheeler.core.dao.model.partial.Location;
import lombok.Data;

import java.util.List;

@Data
public class Education implements Model {

    private String id;
    private String name;
    private String degree;
    private List<String> descriptions;
    private Integer end;
    private String field;
    private Location location;
    private Integer start;

    public static String getTableName() {
        return "education";
    }
}
