package com.wheeler.aws.dao.repository;

import com.wheeler.aws.dao.connection.DynamoConnector;
import com.wheeler.aws.dao.repository.base.AbstractDynamoModelRepository;
import com.wheeler.core.dao.model.Education;
import com.wheeler.core.dao.repository.ModelRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EducationRepository
        extends AbstractDynamoModelRepository<Education>
        implements ModelRepository<Education> {

    public EducationRepository(final DynamoConnector dynamoConnector) {
        super(dynamoConnector);
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
