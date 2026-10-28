package com.example.portfolio.experience;

import com.example.portfolio.common.response.ExperienceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/v1/experiences")
public class ExperienceController {

    private final ExperienceService experienceService;
    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ExperienceResponse>> getExperiences() {

        return ResponseEntity.ok().body(this.experienceService.getExperiences());
    }
}
