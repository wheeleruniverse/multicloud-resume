package com.wheeler.azure.dao.repository;

import com.wheeler.azure.dao.connection.CosmosConnector;
import com.wheeler.azure.dao.repository.base.AbstractCosmosModelRepository;
import com.wheeler.core.dao.model.Education;
import com.wheeler.core.dao.repository.ModelRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EducationRepository
        extends AbstractCosmosModelRepository<Education>
        implements ModelRepository<Education> {

    public EducationRepository(final CosmosConnector cosmosConnector) {
        super(cosmosConnector);
    }

    @Override
    public String getTableName() {
        return Education.getTableName();
    }

    @Override
    public Class<Education> getTableType() {
        return Education.class;
    }
}
