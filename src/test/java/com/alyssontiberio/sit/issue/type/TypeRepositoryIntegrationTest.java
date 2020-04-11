package com.alyssontiberio.sit.issue.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
class TypeRepositoryIntegrationTest {

    @Autowired
    private TypeRepository typeRepository;

    @Test
    @DisplayName("When find by description then return status")
    void findByDescription() {

        assertFalse(typeRepository.findByDescription(TypeService.DEFECT).isEmpty());
        assertFalse(typeRepository.findByDescription(TypeService.FEATURE).isEmpty());
        assertFalse(typeRepository.findByDescription(TypeService.PATCH).isEmpty());
    }
}
