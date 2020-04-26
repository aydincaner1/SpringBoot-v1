package com.caner.issuemanagement.dto;

import com.caner.issuemanagement.entity.IssueStatus;
import com.caner.issuemanagement.entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class IssueDto {
    private Long id;
    private String description;
    private String details;
    private Date date;
    private IssueStatus issueStatus;
    private UserDto assignee;
    private ProjectDto project;
}
