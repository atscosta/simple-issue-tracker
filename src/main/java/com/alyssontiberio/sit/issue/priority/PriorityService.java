package com.alyssontiberio.sit.issue.priority;

import com.alyssontiberio.sit.issue.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PriorityService {

    public static final String LOW = "Low";
    public static final String NORMAL = "Normal";
    public static final String HIGH = "High";
    public static final String URGENT = "Urgent";

    private final PriorityRepository priorityRepository;

    @Cacheable("priorityList")
    public List<String> findAll() {
        return priorityRepository.findAll().stream()
                .map(Priority::getDescription)
                .collect(Collectors.toList());
    }

    public Priority findByDescription(String description) {
        return this.priorityRepository
                .findByDescription(description)
                .orElseThrow(ResourceNotFoundException::new);

    }

}
