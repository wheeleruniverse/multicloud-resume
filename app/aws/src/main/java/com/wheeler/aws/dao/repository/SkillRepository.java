package com.wheeler.aws.dao.repository;

import com.wheeler.aws.dao.connection.DynamoConnector;
import com.wheeler.aws.dao.repository.base.AbstractDynamoModelRepository;
import com.wheeler.core.dao.model.Skill;
import com.wheeler.core.dao.repository.ModelRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SkillRepository
        extends AbstractDynamoModelRepository<Skill>
        implements ModelRepository<Skill> {

    public SkillRepository(final DynamoConnector dynamoConnector) {
        super(dynamoConnector);
    }

    @Override
    public String getTableName() {
        return Skill.getTableName();
    }

    @Override
    public Class<Skill> getTableType() {
        return Skill.class;
    }
}
