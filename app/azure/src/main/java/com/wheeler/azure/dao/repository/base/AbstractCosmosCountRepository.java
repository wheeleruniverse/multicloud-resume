package com.wheeler.azure.dao.repository.base;

import com.azure.cosmos.models.CosmosItemRequestOptions;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.wheeler.azure.dao.connection.CosmosConnector;
import com.wheeler.core.dao.model.Count;
import com.wheeler.core.exception.BadRequestException;

public abstract class AbstractCosmosCountRepository extends AbstractCosmosRepository<Count> {

    public AbstractCosmosCountRepository(final CosmosConnector cosmosConnector) {
        super(cosmosConnector);
    }

    @Override
    public Class<Count> getTableType() {
        return Count.class;
    }

    public Count count(){
        final String table = getTableName();
        final String sql = String.format(
                "select '%s' as name, c.val from %s c where c.id = 'count'",
                table, table
        );
        final CosmosQueryRequestOptions options = cosmosConnector.getQueryOptions();
        return getTable()
                .queryItems(sql, options, Count.class)
                .stream().findFirst().orElse(new Count(table, 0));
    }

    public void increment(){
        final Count current = count();
        current.increment();

        final CosmosItemRequestOptions options = cosmosConnector.getItemOptions();
        getTable().upsertItem(current, options);
    }

    public void load(final Integer value){
        final CosmosItemRequestOptions options = cosmosConnector.getItemOptions();
        getTable().upsertItem(new Count(getTableName(), value), options);
    }
}
