package com.wheeler.dao.repository;

import com.wheeler.dao.connection.CosmosConnector;
import com.wheeler.dao.model.Skill;
import com.wheeler.dao.model.Visitor;
import org.springframework.stereotype.Repository;

@Repository
public class VisitorRepository extends AbstractCosmosRepository<Visitor> {

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
