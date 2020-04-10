package com.alyssontiberio.sit.issue.priority;

import com.alyssontiberio.sit.issue.status.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PriorityService {

    private final PriorityRepository priorityRepository;

    @Cacheable("priorityList")
    public List<String> findAll() {
        return priorityRepository.findAll().stream()
                .map(Priority::getDescription)
                .collect(Collectors.toList());
    }

    public Priority findByDescription(String description) {
        return this.priorityRepository.findByDescription(description)
                .orElseThrow(NoResultException::new);

    }


}
