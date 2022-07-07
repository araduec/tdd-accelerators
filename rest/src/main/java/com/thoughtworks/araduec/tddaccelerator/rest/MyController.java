package com.thoughtworks.araduec.tddaccelerator.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class MyController {

    @GetMapping("/hello")
    public ResponseEntity<?> string() {
        return ResponseEntity.ok("Hello world!");
    }

}
