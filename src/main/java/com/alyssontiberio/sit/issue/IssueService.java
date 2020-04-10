package com.alyssontiberio.sit.issue;

import com.alyssontiberio.sit.issue.priority.Priority;
import com.alyssontiberio.sit.issue.priority.PriorityService;
import com.alyssontiberio.sit.issue.status.Status;
import com.alyssontiberio.sit.issue.status.StatusService;
import com.alyssontiberio.sit.issue.type.Type;
import com.alyssontiberio.sit.issue.type.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;

    private final StatusService statusService;
    private final PriorityService priorityService;
    private final TypeService typeService;

    public List<Issue> findAll() {
        return issueRepository.findAll();
    }

    @Transactional
    public void save(IssueDto issueDto) {

        Issue issue = convertToEntity(issueDto);
        this.issueRepository.save(issue);

    }

    private Issue convertToEntity(IssueDto issueDto) {

        Status status = this.statusService.findByDescription(issueDto.getStatus());
        Priority priority = this.priorityService.findByDescription(issueDto.getPriority());
        Type type = this.typeService.findByDescription(issueDto.getType());

        return Issue.builder()
                .status(status)
                .priority(priority)
                .type(type)
                .build();
    }
}
