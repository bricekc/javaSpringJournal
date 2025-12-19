package com.api.journal.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class controllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testHealthEndpoint() {
        String response = restTemplate.getForObject("/health", String.class);
        assertThat(response).isEqualTo("coucou");
    }

    @Test
    public void testHomeEndpoint() {
        String response = restTemplate.getForObject("/", String.class);
        assertThat(response).isEqualTo("Bienvenue sur l'API Journal!");
    }
}
