# Integration Tests for Eventing

This module shows different methods for writing integration tests for kafka producers and consumers.

In [VerifyWithCapturedOutputIntegrationTests](src/test/java/com/thoughtworks/araduec/tddaccelerator/kafka/VerifyWithCapturedOutputIntegrationTests.java), we validate our expectations by capturing log statements.

In [VerifyWithMockEventHandlerIntegrationTests](src/test/java/com/thoughtworks/araduec/tddaccelerator/kafka/VerifyWithMockEventHandlerIntegrationTests.java), we validate our expectations by capturing the consumer's interactions with its event handler service.

Validating with the event handler service interaction is the recommended approach because you can validate object fields, even those expected to hold PHI/PII (which you wouldn't log).
