package com.wheeler.azure.dao.repository;

import com.wheeler.azure.dao.connection.CosmosConnector;
import com.wheeler.azure.dao.repository.base.AbstractCosmosModelRepository;
import com.wheeler.core.dao.model.Project;
import com.wheeler.core.dao.repository.ModelRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectRepository
        extends AbstractCosmosModelRepository<Project>
        implements ModelRepository<Project> {

    public ProjectRepository(final CosmosConnector cosmosConnector) {
        super(cosmosConnector);
    }

    @Override
    public String getTableName() {
        return Project.getTableName();
    }

    @Override
    public Class<Project> getTableType() {
        return Project.class;
    }
}
