package com.alyssontiberio.sit.issue.type;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.Cacheable;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TypeService {

    private final TypeRepository typeRepository;

    @Cacheable("trackerList")
    public List<String> findAll() {
        return this.typeRepository.findAll().stream()
                .map(Type::getDescription)
                .collect(Collectors.toList());
    }

    public Type findByDescription(String description) {
        return this.typeRepository.findByDescription(description)
                .orElseThrow(NoResultException::new);

    }

}
