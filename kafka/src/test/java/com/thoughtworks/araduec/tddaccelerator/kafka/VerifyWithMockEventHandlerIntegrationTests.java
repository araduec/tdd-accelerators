package com.thoughtworks.araduec.tddaccelerator.kafka;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
@SpringBootTest
public class VerifyWithMockEventHandlerIntegrationTests {

    @Autowired
    MyProducer producer;

    @MockBean
    MyEventHandler handler;

    @Test
    void happyPath() {
        // when
        producer.send("Hello world!");

        // then
        verify(handler, timeout(1000)).handle("Hello world!");
    }

}
