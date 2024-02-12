package com.fidenz_assignment.service_provider_api.service;

import com.fidenz_assignment.service_provider_api.dto.request.common.ProfileRequest;
import com.fidenz_assignment.service_provider_api.mapper.ProfileMapper;
import com.fidenz_assignment.service_provider_api.model.Profile;
import com.fidenz_assignment.service_provider_api.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    @Autowired
    ProfileService(ProfileRepository profileRepository, ProfileMapper profileMapper) {
        this.profileRepository = profileRepository;
        this.profileMapper = profileMapper;
    }

    public <T extends ProfileRequest> Profile  createProfile(T request, Long userId) {
        Profile profile = profileRepository.save(profileMapper.map(request, userId));
        return profile;
    }
}
