package com.wheeler.dao.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Visitor {

    private String id;
    private String name;

    public Visitor(final String name){
        super();
        this.name = name;
    }
}