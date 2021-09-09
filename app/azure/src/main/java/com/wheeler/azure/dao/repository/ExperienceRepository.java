package com.wheeler.azure.dao.repository;

import com.wheeler.core.dao.model.Experience;
import com.wheeler.core.dao.repository.CoreRepository;
import com.wheeler.azure.dao.connection.CosmosConnector;
import org.springframework.stereotype.Repository;

@Repository
public class ExperienceRepository
        extends AbstractCosmosRepository<Experience>
        implements CoreRepository<Experience> {

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
