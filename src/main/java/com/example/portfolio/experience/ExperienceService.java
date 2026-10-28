package com.example.portfolio.experience;


import com.example.portfolio.common.entity.Experience;
import com.example.portfolio.common.response.ExperienceResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {

    private final ExperienceRepository experienceRepository;
    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public List<ExperienceResponse> getExperiences() {
       return experienceRepository.findAllByOrderByDisplayOrderAsc()
               .orElseThrow(() -> new RuntimeException("AHHH, No Experience Found :("))
               .stream()
               .map(experience ->
                   new ExperienceResponse(experience.getCompanyName(),
                           experience.getClient(),
                           experience.getDescription(),
                           experience.getRole(),
                           experience.getStartDate(),
                           experience.getEndDate(),
                           experience.getWorkModel(),
                           experience.getDisplayOrder()
                   )
               )
               .toList();

    }
}
