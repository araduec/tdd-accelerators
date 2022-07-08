package com.thoughtworks.araduec.tddaccelerator.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MyDomainObj {

    public MyDomainObj(String content) {
        this.content = content;
    }

    @Id
    private String id;

    private String content;

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
