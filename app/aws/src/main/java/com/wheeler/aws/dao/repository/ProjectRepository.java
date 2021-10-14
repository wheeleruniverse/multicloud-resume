package com.wheeler.aws.dao.repository;

import com.wheeler.aws.dao.connection.DynamoConnector;
import com.wheeler.aws.dao.repository.base.AbstractDynamoModelRepository;
import com.wheeler.core.dao.model.Project;
import com.wheeler.core.dao.repository.ModelRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectRepository
        extends AbstractDynamoModelRepository<Project>
        implements ModelRepository<Project> {

    public ProjectRepository(final DynamoConnector dynamoConnector) {
        super(dynamoConnector);
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
