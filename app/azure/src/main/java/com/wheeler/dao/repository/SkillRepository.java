package com.wheeler.dao.repository;

import com.wheeler.dao.connection.CosmosConnector;
import com.wheeler.dao.model.Skill;
import org.springframework.stereotype.Repository;

@Repository
public class SkillRepository extends AbstractCosmosRepository<Skill> {

    public SkillRepository(final CosmosConnector cosmosConnector) {
        super(cosmosConnector);
    }

    @Override
    public String getTableName() {
        return "skill";
    }

    @Override
    public Class<Skill> getTableType() {
        return Skill.class;
    }
}
