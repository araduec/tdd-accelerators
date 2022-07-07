package com.thoughtworks.araduec.tddaccelerator.kafka;

import org.springframework.stereotype.Service;

@Service
public class MyEventHandlerImpl implements MyEventHandler {
    @Override
    public void handle(String event) {
        throw new UnsupportedOperationException();
    }
}
