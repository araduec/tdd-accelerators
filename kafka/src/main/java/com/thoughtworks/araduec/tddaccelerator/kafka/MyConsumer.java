package com.thoughtworks.araduec.tddaccelerator.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MyConsumer {
    @Value("${topic.name.consumer}")
    private String topicName;

    private final MyEventHandler handler;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, String> payload){
        log.info("Topic: {}", topicName);
        log.info("Payload Key: {}", payload.key());
        log.info("Payload Headers: {}", payload.headers());
        log.info("Payload Partition: {}", payload.partition());
        log.info("Payload Value: {}", payload.value());
        handler.handle(payload.value());
    }
}
