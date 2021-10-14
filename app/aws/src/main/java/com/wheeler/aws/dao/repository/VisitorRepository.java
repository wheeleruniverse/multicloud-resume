package com.wheeler.aws.dao.repository;

import com.wheeler.aws.dao.connection.DynamoConnector;
import com.wheeler.aws.dao.repository.base.AbstractDynamoCountRepository;
import com.wheeler.core.dao.model.Count;
import com.wheeler.core.dao.model.Visitor;
import com.wheeler.core.dao.repository.CountRepository;
import org.springframework.stereotype.Repository;

@Repository
public class VisitorRepository
        extends AbstractDynamoCountRepository
        implements CountRepository {

    public VisitorRepository(final DynamoConnector dynamoConnector) {
        super(dynamoConnector);
    }

    @Override
    public String getTableName() {
        return Visitor.getTableName();
    }
}
