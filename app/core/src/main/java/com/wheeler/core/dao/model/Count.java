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
    @SuppressWarnings("unused")
    public void setId(String id){
        // suppress firestore warnings
    }
    @SuppressWarnings("unused")
    public Integer getVal() {
        return value;
    }
    @SuppressWarnings("unused")
    public void setVal(Integer value) {
        // maps 'val' to 'value' for databases that reserve the word 'value'
        this.value = value;
    }

    public void increment(){
        if (value == null || value < 0){
            value = 0;
        }
        value++;
    }
}
