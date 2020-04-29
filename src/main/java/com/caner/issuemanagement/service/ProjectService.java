package com.caner.issuemanagement.service;


import com.caner.issuemanagement.dto.ProjectDto;
import com.caner.issuemanagement.entity.Issue;
import com.caner.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    Project save(Project project);

    ProjectDto getById(Long id);

    ProjectDto getByProjectCode(String projectCode);

    List<ProjectDto> getByProjectCodeContains(String projectCode);

    Page<ProjectDto> getAllPageable(Pageable pageable);

    Boolean delete (Project project);
}
