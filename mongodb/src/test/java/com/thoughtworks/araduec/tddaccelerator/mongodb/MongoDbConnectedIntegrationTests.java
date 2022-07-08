package com.thoughtworks.araduec.tddaccelerator.mongodb;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@DirtiesContext
class MongoDbConnectedIntegrationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MyRepository myRepository;

    @Test
    void happyPath() {
        // given
        var objectToSave = new MyDomainObj("Hello world!");

        // when
        myRepository.save(objectToSave);

        // then
        var result = mongoTemplate.findAll(MyDomainObj.class).get(0);
        assertEquals(objectToSave.getContent(), result.getContent());
        assertNotNull(result.getId());
    }
}
