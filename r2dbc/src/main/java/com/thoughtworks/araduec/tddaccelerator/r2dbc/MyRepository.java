package com.thoughtworks.araduec.tddaccelerator.r2dbc;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface MyRepository extends R2dbcRepository<MyDomainObj, Integer> {
}
