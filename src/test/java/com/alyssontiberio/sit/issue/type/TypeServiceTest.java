package com.alyssontiberio.sit.issue.type;

import com.alyssontiberio.sit.issue.ResourceNotFoundException;
import com.alyssontiberio.sit.issue.priority.PriorityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TypeServiceTest {

    private TypeService typeService;

    private final Type feature = new Type(1, TypeService.FEATURE);
    private final Type patch = new Type(2, TypeService.PATCH);
    private final Type defect = new Type(3, TypeService.DEFECT);

    @BeforeEach
    void setMockOutput() {

        final TypeRepository typeRepository = mock(TypeRepository.class);

        when(typeRepository.findByDescription(PriorityService.LOW)).thenReturn(Optional.of(feature));
        when(typeRepository.findByDescription(PriorityService.NORMAL)).thenReturn(Optional.of(patch));
        when(typeRepository.findByDescription(PriorityService.HIGH)).thenReturn(Optional.of(defect));

        this.typeService = new TypeService(typeRepository);

    }

    @Test
    @DisplayName("Find by an invalid description")
    void findByInvalidDescription() {
        assertThrows(ResourceNotFoundException.class, () -> typeService.findByDescription("Invalid"));

    }

    @Test
    @DisplayName("Find All by description")
    void findByDescription() {

        assertThat(this.typeService.findByDescription(PriorityService.LOW), equalTo(feature));
        assertThat(this.typeService.findByDescription(PriorityService.NORMAL), equalTo(patch));
        assertThat(this.typeService.findByDescription(PriorityService.HIGH), equalTo(defect));

    }
}
