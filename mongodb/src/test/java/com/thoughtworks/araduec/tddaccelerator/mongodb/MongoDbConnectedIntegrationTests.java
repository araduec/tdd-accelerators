package com.thoughtworks.araduec.tddaccelerator.mongodb;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.thoughtworks.araduec.tddaccelerator.mongodb.MongoDbConnectedApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@DirtiesContext
class MongoDbConnectedIntegrationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void happyPath() {
        // given
        DBObject objectToSave = BasicDBObjectBuilder.start()
                .add("key", "value")
                .get();

        // when
        mongoTemplate.save(objectToSave, "collection");

        // then
        assertEquals(
                objectToSave,
                mongoTemplate.findAll(DBObject.class, "collection").get(0));
    }
}
