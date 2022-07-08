package com.thoughtworks.araduec.tddaccelerator.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ExtendWith(SpringExtension.class)
class WebIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void happyPath() throws Exception {
        mockMvc.perform(get("/example/hello"))
                .andExpect(status().isOk());
    }

    @Test
    void whenUnauthenticated_getAdmin_shouldReturnForbidden() throws Exception {
        mockMvc.perform(get("/admin/hello"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    @WithMockUser
    public void givenUserWithRoleUser_getAdmin_shouldReturnUnauthorized() throws Exception {
        mockMvc.perform(get("/admin/hello"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void givenUserWithRoleAdmin_getAdmin_shouldReturnOk() throws Exception {
        mockMvc.perform(get("/admin/hello"))
                .andExpect(status().is2xxSuccessful());
    }

}
