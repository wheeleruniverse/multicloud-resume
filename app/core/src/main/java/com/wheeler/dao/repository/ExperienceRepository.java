package com.wheeler.dao.repository;

import com.wheeler.dao.connection.CosmosConnector;
import com.wheeler.dao.model.Experience;
import org.springframework.stereotype.Repository;

@Repository
public class ExperienceRepository extends AbstractCosmosRepository<Experience> {

    public ExperienceRepository(final CosmosConnector cosmosConnector) {
        super(cosmosConnector);
    }

    @Override
    public String getTableName() {
        return "experience";
    }

    @Override
    public Class<Experience> getTableType() {
        return Experience.class;
    }
}
