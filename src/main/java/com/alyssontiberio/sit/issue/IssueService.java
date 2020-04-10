package com.alyssontiberio.sit.issue;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;

    public List<Issue> findAll() {
        return issueRepository.findAll();
    }
}
