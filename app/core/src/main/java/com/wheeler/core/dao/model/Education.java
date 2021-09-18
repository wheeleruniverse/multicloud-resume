package com.wheeler.core.dao.model;

import com.wheeler.core.dao.model.contract.Entity;
import com.wheeler.core.dao.model.partial.Location;
import lombok.Data;

import java.util.List;

@Data
public class Education implements Entity {

    private String id;
    private String name;
    private String degree;
    private List<String> descriptions;
    private Integer end;
    private String field;
    private Location location;
    private Integer start;
}
