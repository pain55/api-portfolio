package com.example.portfolio.common.projects;

import com.example.portfolio.common.entity.Project;
import com.example.portfolio.common.exception.ProjectNotFoundException;
import com.example.portfolio.common.response.ProjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    List<ProjectResponse> getProjects() {

        return projectRepository.findAll()
                .stream()
                .map((ProjectService::toDto))
                .sorted(Comparator.comparing(ProjectResponse::displayOrder))
                .toList();
    }


    ProjectResponse getProjectBySlug(String slug) {
        if(slug==null)
            throw new IllegalArgumentException("slug is null");
        return toDto(this.projectRepository.findBySlug(slug).orElseThrow(()-> new ProjectNotFoundException("Hmm, No project found with slug " + slug)));
    }

    static ProjectResponse toDto(Project project) {
        return new ProjectResponse(project.getSlug(),project.getTitle(),project.getDescription(),project.getSkills(),project.getGithubUrl(),project.getDemoUrl(),project.getDisplayOrder());
    }

}
