package com.vaunskii.springsocial2coud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class HomeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @WithMockUser
    void authenticatedUserCanDisplayHomePage() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    @WithAnonymousUser
    void anonymousUserIsNotAllowedToSeeHomePage() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().is4xxClientError());
    }
}
