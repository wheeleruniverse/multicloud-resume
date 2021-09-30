package com.wheeler.azure.dao.repository;

import com.wheeler.azure.dao.connection.CosmosConnector;
import com.wheeler.azure.dao.repository.base.AbstractCosmosCountRepository;
import com.wheeler.core.dao.model.Visitor;
import com.wheeler.core.dao.repository.CountRepository;
import org.springframework.stereotype.Repository;

@Repository
public class VisitorRepository
        extends AbstractCosmosCountRepository
        implements CountRepository {

    public VisitorRepository(final CosmosConnector cosmosConnector) {
        super(cosmosConnector);
    }

    @Override
    public String getTableName() {
        return Visitor.getTableName();
    }
}
