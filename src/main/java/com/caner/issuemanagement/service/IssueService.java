package com.caner.issuemanagement.service;

import com.caner.issuemanagement.dto.IssueDto;
import com.caner.issuemanagement.entity.Issue;
import com.caner.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete (IssueDto issue);
}
