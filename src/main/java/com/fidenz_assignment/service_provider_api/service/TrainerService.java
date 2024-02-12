package com.fidenz_assignment.service_provider_api.service;

import com.fidenz_assignment.service_provider_api.dto.request.TrainerCreateRequest;
import com.fidenz_assignment.service_provider_api.dto.response.ActionResultResponse;
import com.fidenz_assignment.service_provider_api.enums.UserRole;
import com.fidenz_assignment.service_provider_api.mapper.TrainerMapper;
import com.fidenz_assignment.service_provider_api.model.User;
import com.fidenz_assignment.service_provider_api.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {

    private final UserService userService;
    private final ProfileService profileService;
    private final TrainerRepository TrainerRepository;
    private TrainerMapper TrainerMapper;

    @Autowired
    public TrainerService(
            UserService userService,
            ProfileService profileService,
            TrainerRepository TrainerRepository,
            TrainerMapper TrainerMapper
    ) {
        this.userService = userService;
        this.profileService = profileService;
        this.TrainerRepository = TrainerRepository;
        this.TrainerMapper = TrainerMapper;
    }

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
