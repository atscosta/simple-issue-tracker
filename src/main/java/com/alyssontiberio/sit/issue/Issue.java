package com.alyssontiberio.sit.issue;

import com.alyssontiberio.sit.issue.comment.Comment;
import com.alyssontiberio.sit.issue.priority.Priority;
import com.alyssontiberio.sit.issue.status.Status;
import com.alyssontiberio.sit.issue.type.Type;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "tb_issue")
@Entity
@Builder
public class Issue {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "fk_priority")
    private Priority priority;

    @OneToOne
    @JoinColumn(name = "fk_tracker")
    private Type type;

    @OneToOne
    @JoinColumn(name = "fk_status")
    private Status status;

    private String version;

    @OneToMany(mappedBy = "issue", fetch = FetchType.LAZY)
    private List<Comment> comments;
}
