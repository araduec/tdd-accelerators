# Integration Tests for Eventing

This module shows methods for writing integration tests for kafka consumers and producers.

In [EmbeddedKafkaIntegrationTests](src/test/java/com/thoughtworks/araduec/tddaccelerator/kafka/EmbeddedKafkaIntegrationTests.java),
we test `MyConsumer.consume()` by injecting a mock in place of an event handler implementation.


