package com.alyssontiberio.sit.issue.priority;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface PriorityRepository extends JpaRepository<Priority, Integer> {

    Optional<Priority> findByDescription(String description);
}
