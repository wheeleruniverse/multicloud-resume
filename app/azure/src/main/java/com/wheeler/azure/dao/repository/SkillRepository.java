package com.wheeler.azure.dao.repository;

import com.wheeler.core.dao.model.Skill;
import com.wheeler.core.dao.repository.CoreRepository;
import com.wheeler.azure.dao.connection.CosmosConnector;
import org.springframework.stereotype.Repository;

@Repository
public class SkillRepository
        extends AbstractCosmosRepository<Skill>
        implements CoreRepository<Skill> {

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
