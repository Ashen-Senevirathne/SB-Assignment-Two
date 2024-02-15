package com.fidenz_assignment.service_provider_api.service;

import com.fidenz_assignment.service_provider_api.dto.request.common.ProfileRequest;
import com.fidenz_assignment.service_provider_api.mapper.ProfileMapper;
import com.fidenz_assignment.service_provider_api.model.Profile;
import com.fidenz_assignment.service_provider_api.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    public <T extends ProfileRequest> Profile  createProfile(T request, Long userId) {
        return profileRepository.save(profileMapper.map(request, userId));
    }
}
