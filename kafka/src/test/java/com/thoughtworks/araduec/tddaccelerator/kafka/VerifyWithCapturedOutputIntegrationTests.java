package com.thoughtworks.araduec.tddaccelerator.kafka;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import static org.mockito.Mockito.verify;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
public class VerifyWithCapturedOutputIntegrationTests {

    @Autowired
    MyProducer producer;

    @Test
    void happyPath(CapturedOutput output) throws InterruptedException {
        // when
        producer.send("Hello world!");

        // and
        waitFor(1000);

        // then
        Assertions.assertTrue(output.getOut().contains("Payload Value: Hello world!"));
    }

    private void waitFor(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }

}
