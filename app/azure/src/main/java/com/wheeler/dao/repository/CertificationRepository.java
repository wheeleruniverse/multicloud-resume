package com.wheeler.dao.repository;

import com.wheeler.core.dao.model.Certification;
import com.wheeler.core.dao.repository.CoreRepository;
import com.wheeler.dao.connection.CosmosConnector;
import org.springframework.stereotype.Repository;

@Repository
public class CertificationRepository
        extends AbstractCosmosRepository<Certification>
        implements CoreRepository<Certification> {

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
