package com.wheeler.core.dao.model;

import com.wheeler.core.dao.model.contract.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Count implements Model {

    private String name;
    private Integer value;

    @Override
    public String getId() {
        return "count";
    }

    public void setId(String id){
        // suppress firestore warnings
    }

    public void increment(){
        if (value == null || value < 0){
            value = 0;
        }
        value++;
    }
}
