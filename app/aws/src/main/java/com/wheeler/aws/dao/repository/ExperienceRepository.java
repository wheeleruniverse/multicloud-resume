package com.wheeler.aws.dao.repository;

import com.wheeler.aws.dao.connection.DynamoConnector;
import com.wheeler.aws.dao.repository.base.AbstractDynamoModelRepository;
import com.wheeler.core.dao.model.Experience;
import com.wheeler.core.dao.repository.ModelRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ExperienceRepository
        extends AbstractDynamoModelRepository<Experience>
        implements ModelRepository<Experience> {

    public ExperienceRepository(final DynamoConnector dynamoConnector) {
        super(dynamoConnector);
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
