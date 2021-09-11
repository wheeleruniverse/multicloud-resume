package com.wheeler.azure.dao.repository;

import com.wheeler.core.dao.model.Visitor;
import com.wheeler.core.dao.repository.CoreRepository;
import com.wheeler.azure.dao.connection.CosmosConnector;
import org.springframework.stereotype.Repository;

@Repository
public class VisitorRepository
        extends AbstractCosmosRepository<Visitor>
        implements CoreRepository<Visitor> {

    public VisitorRepository(final CosmosConnector cosmosConnector) {
        super(cosmosConnector);
    }

    @Override
    public String getTableName() {
        return "visitor";
    }

    @Override
    public Class<Visitor> getTableType() {
        return Visitor.class;
    }
}
