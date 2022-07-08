package com.thoughtworks.araduec.tddaccelerator.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MyRepository extends MongoRepository<MyDomainObj, String> {
}
