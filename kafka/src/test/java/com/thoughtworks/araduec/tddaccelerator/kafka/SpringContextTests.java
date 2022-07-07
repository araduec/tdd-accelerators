package com.thoughtworks.araduec.tddaccelerator.kafka;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringContextTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> Exception.class);
    }

}