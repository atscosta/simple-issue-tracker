package com.alyssontiberio.sit.issue.status;

import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StatusService {

    private final StatusRepository statusRepository;

    @Cacheable("statusList")
    public List<String> findAll() {
        return this.statusRepository.findAll().stream()
                .map(Status::getDescription)
                .collect(Collectors.toList());
    }

    public Status findByDescription(String description) {
        return this.statusRepository.findByDescription(description)
                .orElseThrow(NoResultException::new);

    }
}
