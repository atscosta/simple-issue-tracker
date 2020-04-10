package com.alyssontiberio.sit.issue.comment;

import com.alyssontiberio.sit.issue.Issue;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_issue")
    private Issue issue;

    private String text;

    private LocalDateTime dateTime;

}
