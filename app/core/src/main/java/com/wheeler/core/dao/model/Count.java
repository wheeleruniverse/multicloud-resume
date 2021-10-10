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

    /**
     *
     * @return the constant 'count' as the id
     */
    @Override
    public String getId() {
        return "count";
    }

    /**
     * stub method that only exists to suppress warnings with firestore
     * @param id doesn't matter
     */
    public void setId(String id){
       // do nothing
    }

    /**
     * alias to getValue
     * @return the value
     */
    public Integer getVal() {
        return value;
    }

    /**
     * alias to setValue
     * note: maps 'val' to 'value' for databases that reserve the word 'value'
     * @param value the value to set
     */
    public void setVal(Integer value) {
        this.value = value;
    }

    /**
     * increments the value by one
     */
    public void increment(){
        if (value == null || value < 0){
            value = 0;
        }
        value++;
    }
}
