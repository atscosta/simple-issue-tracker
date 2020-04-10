package com.alyssontiberio.sit.issue;

import lombok.Data;

@Data
public class IssueDto {

    private String priority;
    private String status;
    private String type;
    private String version;
    private String comment;
}
