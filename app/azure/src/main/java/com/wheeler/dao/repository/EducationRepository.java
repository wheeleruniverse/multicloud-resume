package com.wheeler.dao.repository;

import com.wheeler.core.dao.model.Education;
import com.wheeler.core.dao.repository.CoreRepository;
import com.wheeler.dao.connection.CosmosConnector;
import org.springframework.stereotype.Repository;

@Repository
public class EducationRepository
        extends AbstractCosmosRepository<Education>
        implements CoreRepository<Education> {

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
