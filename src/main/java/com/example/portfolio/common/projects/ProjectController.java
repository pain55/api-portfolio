package com.example.portfolio.common.projects;

import com.example.portfolio.common.response.ProjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ProjectResponse>> getAllProjects() {
        return ResponseEntity.ok(this.projectService.getProjects());
    }

    @GetMapping("/{slug}")
    public ResponseEntity<ProjectResponse> getProject(@PathVariable String slug) {
        return ResponseEntity.ok(this.projectService.getProjectBySlug(slug));
    }

}
