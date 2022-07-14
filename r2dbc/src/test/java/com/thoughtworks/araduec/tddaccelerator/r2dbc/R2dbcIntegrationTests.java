package com.thoughtworks.araduec.tddaccelerator.r2dbc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.dialect.H2Dialect;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataR2dbcTest
@ExtendWith(SpringExtension.class)
class R2dbcIntegrationTests {
    @Autowired
    private DatabaseClient springR2dbcClient;
    @Autowired
    private MyRepository repository;

    @Test
    void uuidGeneration() {
        //given
        var myDomainObj = new MyDomainObj(null, "content");
        var template = new R2dbcEntityTemplate(springR2dbcClient, H2Dialect.INSTANCE);

        //when
        template.insert(MyDomainObj.class).using(myDomainObj).then()
                .as(StepVerifier::create).verifyComplete();

        //then
        repository.findAll().as(StepVerifier::create)
                .assertNext(actual -> assertNotNull(actual.id())).verifyComplete();
    }
}
