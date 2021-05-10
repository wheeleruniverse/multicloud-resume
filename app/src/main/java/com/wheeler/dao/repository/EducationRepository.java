package com.wheeler.dao.repository;

import com.wheeler.dao.connection.CosmosConnector;
import com.wheeler.dao.model.Certification;
import com.wheeler.dao.model.Education;
import org.springframework.stereotype.Repository;

@Repository
public class EducationRepository extends AbstractCosmosRepository<Education> {

    public EducationRepository(final CosmosConnector cosmosConnector) {
        super(cosmosConnector);
    }

    @Override
    public String getTableName() {
        return "education";
    }

    @Override
    public Class<Education> getTableType() {
        return Education.class;
    }
}
