package com.alyssontiberio.sit.issue.status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface StatusRepository extends JpaRepository<Status, Integer> {

    Optional<Status> findByDescription(String description);
}
