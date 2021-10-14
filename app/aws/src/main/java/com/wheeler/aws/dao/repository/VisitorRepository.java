package com.wheeler.aws.dao.repository;

import com.wheeler.aws.dao.connection.DynamoConnector;
import com.wheeler.core.dao.model.Count;
import com.wheeler.core.dao.model.Visitor;
import com.wheeler.core.dao.repository.CountRepository;
import org.springframework.stereotype.Repository;

@Repository
public class VisitorRepository
        implements CountRepository {

    public VisitorRepository(final DynamoConnector dynamoConnector) {
        //super(dynamoConnector);
    }

    //@Override
    public String getTableName() {
        return Visitor.getTableName();
    }

    @Override
    public Count count() {
        return null;
    }

    @Override
    public void increment() {

    }

    @Override
    public void load(Integer value) {

    }
}
