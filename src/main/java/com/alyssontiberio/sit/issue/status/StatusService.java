package com.alyssontiberio.sit.issue.status;

import com.alyssontiberio.sit.issue.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StatusService {

    public static final String NEW = "New";
    public static final String CONFIRMED = "Confirmed";
    public static final String RESOLVED = "Resolved";
    public static final String CLOSED = "Closed";
    public static final String REOPENED = "Reopened";

    private final StatusRepository statusRepository;

    @Cacheable("statusList")
    public List<String> findAll() {
        return this.statusRepository.findAll().stream()
                .map(Status::getDescription)
                .collect(Collectors.toList());
    }

    public Status findByDescription(String description) {
        return this.statusRepository
                .findByDescription(description)
                .orElseThrow(ResourceNotFoundException::new);

    }
}
