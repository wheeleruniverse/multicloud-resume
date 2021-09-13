package com.wheeler.gcp.dao.repository;

import com.wheeler.core.dao.model.Skill;
import com.wheeler.core.dao.repository.CoreRepository;
import com.wheeler.gcp.dao.connection.FirestoreConnector;
import org.springframework.stereotype.Repository;

@Repository
public class SkillRepository
        extends AbstractFirestoreRepository<Skill>
        implements CoreRepository<Skill> {

    public SkillRepository(final FirestoreConnector firestoreConnector) {
        super(firestoreConnector);
    }

    @Override
    public String getTableName() {
        return "skill";
    }

    @Override
    public Class<Skill> getTableType() {
        return Skill.class;
    }
}
