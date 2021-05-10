package com.wheeler.dao.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Certification {

    private String id;
    private String name;
    private String credentialId;
    private String description;
    private LocalDate expiry;
    private LocalDate issued;
    private String level;
    private String vendor;
}
