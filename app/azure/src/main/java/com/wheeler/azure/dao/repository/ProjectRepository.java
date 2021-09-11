package com.wheeler.azure.dao.repository;

import com.wheeler.core.dao.model.Project;
import com.wheeler.core.dao.repository.CoreRepository;
import com.wheeler.azure.dao.connection.CosmosConnector;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectRepository
        extends AbstractCosmosRepository<Project>
        implements CoreRepository<Project> {

    public ProjectRepository(final CosmosConnector cosmosConnector) {
        super(cosmosConnector);
    }

    @Override
    public String getTableName() {
        return "project";
    }

    @Override
    public Class<Project> getTableType() {
        return Project.class;
    }
}
