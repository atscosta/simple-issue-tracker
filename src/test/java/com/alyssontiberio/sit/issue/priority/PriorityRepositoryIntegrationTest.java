package com.alyssontiberio.sit.issue.priority;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static com.alyssontiberio.sit.issue.priority.PriorityService.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PriorityRepositoryIntegrationTest {

    @Autowired
    private PriorityRepository priorityRepository;

    @Test
    @DisplayName("When find by description then return status")
    void findByDescription() {

        assertFalse(priorityRepository.findByDescription(LOW).isEmpty());
        assertFalse(priorityRepository.findByDescription(NORMAL).isEmpty());
        assertFalse(priorityRepository.findByDescription(HIGH).isEmpty());
        assertFalse(priorityRepository.findByDescription(URGENT).isEmpty());
    }
}
