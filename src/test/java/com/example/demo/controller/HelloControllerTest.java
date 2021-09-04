package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getHelloWorld() throws Exception {
        mockMvc.perform(get("/success"))
                .andExpect(status().isOk())
                .andExpect(content().string("success"))
                .andReturn();
    }

    @Test
    void serverErrorMessage() {
    }

    @Test
    void onlystatus() {
    }

    @Test
    void header() {
    }
}