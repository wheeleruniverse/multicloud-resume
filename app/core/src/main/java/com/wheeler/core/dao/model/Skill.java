package com.wheeler.core.dao.model;

import com.wheeler.core.dao.constant.SkillLevel;
import com.wheeler.core.dao.model.contract.Model;
import lombok.Data;

import java.util.List;

@Data
public class Skill implements Model {

    private String id;
    private String name;
    private SkillLevel level;
    private List<String> projects;
    private String type;

    public static String getTableName() {
        return "skill";
    }

    /**
     * Sets the SkillLevel with a String instead of an enumerator.
     * @param level the SkillLevel value as a String.
     */
    public void setLevel(final String level){
        if (level != null) {
            this.level = SkillLevel.valueOf(level);
        }
    }
}