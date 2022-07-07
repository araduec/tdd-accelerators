package com.thoughtworks.araduec.tddaccelerator.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class EventingApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventingApplication.class, args);
    }

}
