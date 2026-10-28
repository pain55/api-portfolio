package com.example.portfolio.profile;

import com.example.portfolio.common.entity.Profile;
import com.example.portfolio.common.exception.ProfileNotFoundException;
import com.example.portfolio.common.response.ProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public ProfileResponse getProfile() {

        Profile profile = this.profileRepository.findFirstByOrderByIdAsc().orElseThrow(()-> new ProfileNotFoundException("Errr, Profile not found!!!"));

        return new ProfileResponse(profile.getName(), profile.getTitle(), profile.getDescription(), profile.getLocation(), profile.getResumeUrl());
    }
}
