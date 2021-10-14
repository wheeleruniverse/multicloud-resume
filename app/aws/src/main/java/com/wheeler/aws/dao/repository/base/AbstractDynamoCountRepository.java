package com.wheeler.aws.dao.repository.base;

import com.wheeler.aws.dao.connection.DynamoConnector;
import com.wheeler.core.dao.model.Count;

public abstract class AbstractDynamoCountRepository extends AbstractDynamoRepository<Count> {

    public AbstractDynamoCountRepository(final DynamoConnector dynamoConnector) {
        super(dynamoConnector);
    }

    @Override
    public Class<Count> getTableType() {
        return Count.class;
    }

    public Count count(){
        final Count current = fromItem(dynamoClient.getItem(createGetItemRequest("count")).item());
        return current != null ? current : new Count(getTableName(), 0);
    }

    public void increment(){
        final Count current = count();
        current.increment();
        putItem(current);
    }

    public void load(final Integer value){
        putItem(new Count(getTableName(), value));
    }
}
