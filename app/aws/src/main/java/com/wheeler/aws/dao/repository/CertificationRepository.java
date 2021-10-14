package com.wheeler.aws.dao.repository;

import com.wheeler.aws.dao.connection.DynamoConnector;
import com.wheeler.aws.dao.repository.base.AbstractDynamoModelRepository;
import com.wheeler.core.dao.model.Certification;
import com.wheeler.core.dao.repository.ModelRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CertificationRepository
        extends AbstractDynamoModelRepository<Certification>
        implements ModelRepository<Certification> {

    public CertificationRepository(final DynamoConnector dynamoConnector) {
        super(dynamoConnector);
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
