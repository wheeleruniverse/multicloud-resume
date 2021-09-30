package com.wheeler.azure.dao.repository;

import com.wheeler.azure.dao.connection.CosmosConnector;
import com.wheeler.azure.dao.repository.base.AbstractCosmosModelRepository;
import com.wheeler.core.dao.model.Certification;
import com.wheeler.core.dao.repository.ModelRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CertificationRepository
        extends AbstractCosmosModelRepository<Certification>
        implements ModelRepository<Certification> {

    public CertificationRepository(final CosmosConnector cosmosConnector) {
        super(cosmosConnector);
    }

    @Override
    public String getTableName() {
        return Certification.getTableName();
    }

    @Override
    public Class<Certification> getTableType() {
        return Certification.class;
    }
}
