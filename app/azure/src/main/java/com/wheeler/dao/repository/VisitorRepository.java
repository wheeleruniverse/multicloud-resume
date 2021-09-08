package com.wheeler.dao.repository;

import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.wheeler.dao.connection.CosmosConnector;
import com.wheeler.dao.model.Skill;
import com.wheeler.dao.model.Visitor;
import com.wheeler.dao.model.VisitorCount;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<VisitorCount> countByName(){
        final String sql = String.format("select i.name, count(i.id) as cnt from %s i group by i.name", getTableName());
        final CosmosQueryRequestOptions options = cosmosConnector.getQueryOptions();
        return getTable()
                .queryItems(sql, options, VisitorCount.class)
                .stream().collect(Collectors.toList());
    }
}
