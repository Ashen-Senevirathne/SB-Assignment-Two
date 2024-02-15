package com.fidenz_assignment.service_provider_api.mapper;

import com.fidenz_assignment.service_provider_api.dto.request.common.ProfileRequest;
import com.fidenz_assignment.service_provider_api.model.Profile;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProfileMapper {
    private final ModelMapper modelMapper;

    public <T extends ProfileRequest> Profile map(T request, Long userId){
        Profile profile  = modelMapper.map(request, Profile.class);
        profile.setUserId(userId);
        return profile;
    }
}
