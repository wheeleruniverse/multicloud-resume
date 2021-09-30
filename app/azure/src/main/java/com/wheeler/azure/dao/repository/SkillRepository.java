package com.wheeler.azure.dao.repository;

import com.wheeler.azure.dao.connection.CosmosConnector;
import com.wheeler.azure.dao.repository.base.AbstractCosmosModelRepository;
import com.wheeler.core.dao.model.Skill;
import com.wheeler.core.dao.repository.ModelRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SkillRepository
        extends AbstractCosmosModelRepository<Skill>
        implements ModelRepository<Skill> {

    public SkillRepository(final CosmosConnector cosmosConnector) {
        super(cosmosConnector);
    }

    @Override
    public String getTableName() {
        return Skill.getTableName();
    }

    @Override
    public Class<Skill> getTableType() {
        return Skill.class;
    }
}
