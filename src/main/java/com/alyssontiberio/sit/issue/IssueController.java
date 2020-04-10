package com.alyssontiberio.sit.issue;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("issues")
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;

    @GetMapping
    public List<Issue> list() {
        return issueService.findAll();
    }

    @PostMapping
    public void save(IssueDto dto) {
        this.issueService.save(dto);
    }

}
