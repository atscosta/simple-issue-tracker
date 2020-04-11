package com.alyssontiberio.sit.issue.priority;

import com.alyssontiberio.sit.issue.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PriorityServiceTest {

    private PriorityService priorityService;

    private final Priority low = new Priority(1, PriorityService.LOW);
    private final Priority normal = new Priority(2, PriorityService.NORMAL);
    private final Priority high = new Priority(3, PriorityService.HIGH);
    private final Priority urgent = new Priority(4, PriorityService.URGENT);

    @BeforeEach
    void setMockOutput() {

        final PriorityRepository priorityRepository = mock(PriorityRepository.class);

        when(priorityRepository.findByDescription(PriorityService.LOW)).thenReturn(Optional.of(low));
        when(priorityRepository.findByDescription(PriorityService.NORMAL)).thenReturn(Optional.of(normal));
        when(priorityRepository.findByDescription(PriorityService.HIGH)).thenReturn(Optional.of(high));
        when(priorityRepository.findByDescription(PriorityService.URGENT)).thenReturn(Optional.of(urgent));

        this.priorityService = new PriorityService(priorityRepository);

    }

    @Test
    @DisplayName("Find by an invalid description")
    void findByInvalidDescription() {
        assertThrows(ResourceNotFoundException.class, () -> priorityService.findByDescription("Invalid"));

    }

    @Test
    @DisplayName("Find All by description")
    void findByDescription() {

        assertThat(this.priorityService.findByDescription(PriorityService.LOW), equalTo(low));
        assertThat(this.priorityService.findByDescription(PriorityService.NORMAL), equalTo(normal));
        assertThat(this.priorityService.findByDescription(PriorityService.HIGH), equalTo(high));
        assertThat(this.priorityService.findByDescription(PriorityService.URGENT), equalTo(urgent));

    }

}
