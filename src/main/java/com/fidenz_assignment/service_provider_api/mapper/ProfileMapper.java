package com.fidenz_assignment.service_provider_api.mapper;

import com.fidenz_assignment.service_provider_api.dto.request.common.ProfileRequest;
import com.fidenz_assignment.service_provider_api.model.Profile;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {
    private final ModelMapper modelMapper;

    @Autowired
    ProfileMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <T extends ProfileRequest> Profile map(T request, Long userId){
        Profile profile  = modelMapper.map(request, Profile.class);
        profile.setUserId(userId);
        return profile;
    }
}
