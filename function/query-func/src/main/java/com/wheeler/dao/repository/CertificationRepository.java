package com.wheeler.dao.repository;

import com.azure.cosmos.CosmosContainer;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.wheeler.dao.CosmosConnector;
import com.wheeler.dao.model.Certification;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class CertificationRepository {

    private static final CosmosQueryRequestOptions OPTIONS = new CosmosQueryRequestOptions();
    private static final CosmosContainer TABLE = CosmosConnector.getTable("certification");
    private static final String FIND_ALL_SQL = "select * from certification";
    private static final String FIND_ONE_SQL = "select * from certification where id = %s";


    public static List<Certification> findAll() {
        return TABLE.queryItems(FIND_ALL_SQL, OPTIONS, Certification.class).stream().collect(Collectors.toList());
    }

    public static Certification findOne(String id) {
        final String sql = String.format(FIND_ONE_SQL, id);
        return TABLE.queryItems(sql, OPTIONS, Certification.class).stream().findAny().orElse(null);
    }
}
