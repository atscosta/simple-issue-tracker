package com.alyssontiberio.sit.issue.status;

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

class StatusServiceTest {

    private StatusService statusService;

    private final Status newStatus = new Status(1, StatusService.NEW);
    private final Status closed = new Status(2, StatusService.CLOSED);
    private final Status confirmed = new Status(3, StatusService.CONFIRMED);
    private final Status resolved = new Status(4, StatusService.RESOLVED);
    private final Status reopened = new Status(5, StatusService.REOPENED);

    @BeforeEach
    void setMockOutput() {

        final StatusRepository statusRepository = mock(StatusRepository.class);

        when(statusRepository.findByDescription(StatusService.NEW)).thenReturn(Optional.of(newStatus));
        when(statusRepository.findByDescription(StatusService.CLOSED)).thenReturn(Optional.of(closed));
        when(statusRepository.findByDescription(StatusService.CONFIRMED)).thenReturn(Optional.of(confirmed));
        when(statusRepository.findByDescription(StatusService.RESOLVED)).thenReturn(Optional.of(resolved));
        when(statusRepository.findByDescription(StatusService.REOPENED)).thenReturn(Optional.of(reopened));

        this.statusService = new StatusService(statusRepository);

    }

    @Test
    @DisplayName("Find by an invalid description")
    void findByInvalidDescription() {
        assertThrows(ResourceNotFoundException.class, () -> statusService.findByDescription("Invalid"));

    }

    @Test
    @DisplayName("Find All by description")
    void findByDescription() {

        assertThat(this.statusService.findByDescription(StatusService.NEW), equalTo(newStatus));
        assertThat(this.statusService.findByDescription(StatusService.CLOSED), equalTo(closed));
        assertThat(this.statusService.findByDescription(StatusService.CONFIRMED), equalTo(confirmed));
        assertThat(this.statusService.findByDescription(StatusService.RESOLVED), equalTo(resolved));
        assertThat(this.statusService.findByDescription(StatusService.REOPENED), equalTo(reopened));

    }
}
