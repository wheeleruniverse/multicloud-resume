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
/*
        "name":"Full Sail University",
        "degree":"Bachelor of Science",
        "description":"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris venenatis purus ac mauris vehicula, tristique tempor tellus lobortis. Fusce semper eu elit ac elementum. Aenean tincidunt venenatis nisl, at egestas massa ullamcorper at. Maecenas dui ex, egestas at velit eu, dictum tempor dolor. Donec varius ac nisi sit amet ultrices.",
        "end_year":2016,
        "field":"Game Design and Development",
        "location":{
            "address":"3300 University Blvd",
            "city":"Winter Park",
            "remote":true,
            "state":"Florida",
            "zip":"32792"
        },
        "start_year":2013
 */