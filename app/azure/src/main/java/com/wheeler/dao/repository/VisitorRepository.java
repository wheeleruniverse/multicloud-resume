package com.wheeler.dao.repository;

import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.wheeler.core.dao.model.Visitor;
import com.wheeler.core.dao.model.VisitorCount;
import com.wheeler.core.dao.repository.CoreRepository;
import com.wheeler.dao.connection.CosmosConnector;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<VisitorCount> countByName(){
        final String sql = String.format("select i.name, count(i.id) as cnt from %s i group by i.name", getTableName());
        final CosmosQueryRequestOptions options = cosmosConnector.getQueryOptions();
        return getTable()
                .queryItems(sql, options, VisitorCount.class)
                .stream().collect(Collectors.toList());
    }
}
