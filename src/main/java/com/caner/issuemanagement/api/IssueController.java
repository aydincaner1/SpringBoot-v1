package com.caner.issuemanagement.api;

import com.caner.issuemanagement.dto.IssueDto;
import com.caner.issuemanagement.service.impl.IssueServiceImpl;
import com.caner.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Api(value="ApiPaths.IssueCtrl.CTRL",description = "Issue APIs")
public class IssueController {

    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id) {
        IssueDto issue = issueServiceImpl.getById(id);
        return ResponseEntity.ok(issue);
    }

    @PostMapping
    public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto issue) {
        return ResponseEntity.ok(issueServiceImpl.save(issue));
    }

    //@RequestMapping(path = "/project", method = RequestMethod.PUT)
    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody IssueDto issue) {
        return ResponseEntity.ok(issueServiceImpl.update(id, issue));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }
/*
    @GetMapping("/statuses")
    public ResponseEntity<IssueStatus> getAll(@PathVariable(value = "statuses", required = true, String deger) {
        return ResponseEntity.ok(Arrays.asList(IssueStatus.values(deger));
    }*/
}
