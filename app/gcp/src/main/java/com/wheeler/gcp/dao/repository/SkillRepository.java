package com.wheeler.gcp.dao.repository;

import com.wheeler.core.dao.model.Skill;
import com.wheeler.core.dao.repository.ModelRepository;
import com.wheeler.gcp.dao.connection.FirestoreConnector;
import com.wheeler.gcp.dao.repository.base.AbstractFirestoreModelRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SkillRepository
        extends AbstractFirestoreModelRepository<Skill>
        implements ModelRepository<Skill> {

    public SkillRepository(final FirestoreConnector firestoreConnector) {
        super(firestoreConnector);
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
