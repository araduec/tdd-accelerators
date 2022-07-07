package com.thoughtworks.araduec.tddaccelerator.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MyController.class)
class WebIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void happyPath() throws Exception {
        mockMvc.perform(get("/example/hello"))
                .andExpect(status().isOk());
    }

}
