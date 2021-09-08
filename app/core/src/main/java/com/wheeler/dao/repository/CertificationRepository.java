package com.wheeler.dao.repository;

import com.wheeler.dao.connection.CosmosConnector;
import com.wheeler.dao.model.Certification;
import org.springframework.stereotype.Repository;

@Repository
public class CertificationRepository extends AbstractCosmosRepository<Certification> {

    public CertificationRepository(final CosmosConnector cosmosConnector) {
        super(cosmosConnector);
    }

    @Override
    public String getTableName() {
        return "certification";
    }

    @Override
    public Class<Certification> getTableType() {
        return Certification.class;
    }
}
