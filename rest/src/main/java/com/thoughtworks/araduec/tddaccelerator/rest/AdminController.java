package com.thoughtworks.araduec.tddaccelerator.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/hello")
    public ResponseEntity<?> getAdminHello() {
        return ResponseEntity.ok("Hello admin!");
    }

}
