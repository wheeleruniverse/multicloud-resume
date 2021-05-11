package com.wheeler.dao.repository;

import com.wheeler.dao.connection.CosmosConnector;
import com.wheeler.dao.model.Experience;
import com.wheeler.dao.model.Project;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectRepository extends AbstractCosmosRepository<Project> {

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
