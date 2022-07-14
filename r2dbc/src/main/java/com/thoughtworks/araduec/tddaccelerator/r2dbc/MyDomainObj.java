package com.thoughtworks.araduec.tddaccelerator.r2dbc;

import org.springframework.data.annotation.Id;
import java.util.UUID;

public record MyDomainObj(
        @Id UUID id,
        String content
        ) {
}
