package com.wheeler.azure.dao.repository;

import com.wheeler.azure.dao.connection.CosmosConnector;
import com.wheeler.azure.dao.repository.base.AbstractCosmosModelRepository;
import com.wheeler.core.dao.model.Experience;
import com.wheeler.core.dao.repository.ModelRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ExperienceRepository
        extends AbstractCosmosModelRepository<Experience>
        implements ModelRepository<Experience> {

    public ExperienceRepository(final CosmosConnector cosmosConnector) {
        super(cosmosConnector);
    }

    @Override
    public String getTableName() {
        return Experience.getTableName();
    }

    @Override
    public Class<Experience> getTableType() {
        return Experience.class;
    }
}
