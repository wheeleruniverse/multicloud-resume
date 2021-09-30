package com.wheeler.core.dao.model;

import com.wheeler.core.dao.model.contract.Model;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Count implements Model {

    private final String name;
    private Integer value;

    @Override
    public String getId() {
        return "count";
    }

    public void increment(){
        if (value == null || value < 0){
            value = 0;
        }
        value++;
    }
}
