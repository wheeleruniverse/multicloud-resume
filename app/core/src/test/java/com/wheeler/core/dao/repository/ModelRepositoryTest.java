package com.wheeler.core.dao.repository;

import com.google.common.collect.Sets;
import com.wheeler.core.dao.model.Certification;
import com.wheeler.core.utility.JsonUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModelRepositoryTest {

    private Map<String, Certification> database;

    @BeforeEach
    public void beforeEach(){
        final Certification record0 = createCertification("1");
        final Certification record1 = createCertification("2");

        this.database = new HashMap<>();
        this.database.put(record0.getId(), record0);
        this.database.put(record1.getId(), record1);
    }

    @Test
    public void delete(){
        final ModelRepository<Certification> repository = getRepository();
        repository.delete(this.database.get("1"));
        assertEquals(database.keySet(), Sets.newHashSet("2"));
    }

    @Test
    public void findAll(){
        final ModelRepository<Certification> repository = getRepository();
        Set<String> ids = database.keySet();
        repository.findAll().forEach(record ->
            assertTrue(ids.contains(record.getId()), "'ids' should contain 'record.id'")
        );
    }

    @Test
    public void load(){
        final ModelRepository<Certification> repository = getRepository();
        repository.load(JsonUtil.toString(new Certification[]{createCertification("9")}));
        assertEquals(database.keySet(), Sets.newHashSet("9"));
    }

    @Test
    public void save(){
        final ModelRepository<Certification> repository = getRepository();
        repository.save(createCertification("3"));
        assertEquals(database.keySet(), Sets.newHashSet("1", "2", "3"));
    }

    private Certification createCertification(final String id){
        final Certification record = new Certification();
        record.setId(id);

        return record;
    }

    private ModelRepository<Certification> getRepository(){
        return new ModelRepository<>() {
            @Override
            public void delete(Certification record) {
                database.remove(record.getId());
            }
            @Override
            public List<Certification> findAll() {
                return new ArrayList<>(database.values());
            }
            @Override
            public void load(String json) {
                final Certification[] records = JsonUtil.toObject(json, Certification[].class);
                database.clear();
                Arrays.stream(records).forEach(record ->
                    database.put(record.getId(), record)
                );
            }
            @Override
            public void save(Certification record) {
                database.put(record.getId(), record);
            }
        };
    }
}
