package com.wheeler.core.dao.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Visitor {

    private String id;
    private String name;

    public Visitor(){
        super();
        this.id = UUID.randomUUID().toString();
    }
}