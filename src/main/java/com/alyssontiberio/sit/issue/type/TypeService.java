package com.alyssontiberio.sit.issue.type;

import com.alyssontiberio.sit.issue.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.Cacheable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TypeService {

    public static final String DEFECT = "Defect";
    public static final String FEATURE = "Feature";
    public static final String PATCH = "Patch";

    private final TypeRepository typeRepository;

    @Cacheable("trackerList")
    public List<String> findAll() {
        return this.typeRepository.findAll().stream()
                .map(Type::getDescription)
                .collect(Collectors.toList());
    }

    public Type findByDescription(String description) {
        return this.typeRepository
                .findByDescription(description)
                .orElseThrow(ResourceNotFoundException::new);

    }

}
