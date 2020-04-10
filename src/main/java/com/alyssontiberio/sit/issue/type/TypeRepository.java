package com.alyssontiberio.sit.issue.type;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface TypeRepository extends JpaRepository<Type, Integer> {

    Optional<Type> findByDescription(String description);
}
