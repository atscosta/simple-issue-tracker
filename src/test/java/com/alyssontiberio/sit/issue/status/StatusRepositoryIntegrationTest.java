package com.alyssontiberio.sit.issue.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StatusRepositoryIntegrationTest {

    @Autowired
    private StatusRepository statusRepository;

    @Test
    @DisplayName("When find by description then return status")
    void findByDescription() {

        assertFalse(statusRepository.findByDescription("New").isEmpty());
        assertFalse(statusRepository.findByDescription("Confirmed").isEmpty());
        assertFalse(statusRepository.findByDescription("Resolved").isEmpty());
        assertFalse(statusRepository.findByDescription("Closed").isEmpty());
        assertFalse(statusRepository.findByDescription("Reopened").isEmpty());

    }
}
