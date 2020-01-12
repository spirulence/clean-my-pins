package com.cleanmypins.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SampleTest extends BaseTestConfig {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void hasAccountInformation() {
        var entity = restTemplate.getForEntity("/account", String.class);
        assertEquals(entity.getStatusCode(), HttpStatus.OK);
        assertTrue(entity.hasBody());
        assertTrue(Objects.requireNonNull(entity.getBody()).contains("hello"), "response body doesn't contain a greeting");
    }
}
