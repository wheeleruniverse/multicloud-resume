package com.wheeler.core.dao.model;

import com.wheeler.core.dao.model.contract.Entity;
import lombok.Data;

import java.util.UUID;

@Data
public class Visitor implements Entity {

    private String id;
    private String name;

    public Visitor(){
        super();
        this.id = UUID.randomUUID().toString();
    }
}