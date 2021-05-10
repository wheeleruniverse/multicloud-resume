package com.wheeler.dao.repository;

import com.azure.cosmos.CosmosContainer;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.wheeler.dao.connection.CosmosConnector;
import com.wheeler.dao.model.Certification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CertificationRepository {

    private final CosmosConnector cosmosConnector;

    private CosmosContainer table;

    public CertificationRepository(final CosmosConnector cosmosConnector){
        this.cosmosConnector = cosmosConnector;
    }

    public List<Certification> findAll() {
        final String sql = "select * from certification";
        final CosmosQueryRequestOptions options = cosmosConnector.getQueryOptions();
        return getTable()
                .queryItems(sql, options, Certification.class)
                .stream().collect(Collectors.toList());
    }

    public Certification findOne(String id) {
        final String sql = String.format("select * from certification as i where i.id = '%s'", id);
        final CosmosQueryRequestOptions options = cosmosConnector.getQueryOptions();
        return getTable()
                .queryItems(String.format(sql, id), options, Certification.class)
                .stream().findAny().orElse(null);
    }

    private CosmosContainer getTable(){
        if (table == null){
            table = cosmosConnector.getTable("certification");
        }
        return table;
    }
}
