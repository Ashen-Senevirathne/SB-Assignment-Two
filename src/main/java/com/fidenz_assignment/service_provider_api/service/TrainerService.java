package com.fidenz_assignment.service_provider_api.service;

import com.fidenz_assignment.service_provider_api.dto.request.TrainerCreateRequest;
import com.fidenz_assignment.service_provider_api.dto.response.ActionResultResponse;
import com.fidenz_assignment.service_provider_api.enums.UserRole;
import com.fidenz_assignment.service_provider_api.mapper.TrainerMapper;
import com.fidenz_assignment.service_provider_api.model.User;
import com.fidenz_assignment.service_provider_api.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainerService {

    private final UserService userService;
    private final ProfileService profileService;
    private final TrainerRepository TrainerRepository;
    private final TrainerMapper TrainerMapper;

    public ActionResultResponse createTrainer(TrainerCreateRequest TrainerCreateRequest) {

        User createdUser = userService.createUser(TrainerCreateRequest, UserRole.TRAINER);
        profileService.createProfile(TrainerCreateRequest, createdUser.getId());
        TrainerRepository.save(TrainerMapper.map(TrainerCreateRequest, createdUser.getId()));

        return ActionResultResponse.builder()
                .status(true)
                .message("User created with ID: " + createdUser.getId())
                .build();
    }

}
