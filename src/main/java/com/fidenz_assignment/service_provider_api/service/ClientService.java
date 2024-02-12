package com.fidenz_assignment.service_provider_api.service;

import com.fidenz_assignment.service_provider_api.dto.request.ClientCreateRequest;
import com.fidenz_assignment.service_provider_api.dto.response.ActionResultResponse;
import com.fidenz_assignment.service_provider_api.enums.UserRole;
import com.fidenz_assignment.service_provider_api.mapper.ClientMapper;
import com.fidenz_assignment.service_provider_api.model.User;
import com.fidenz_assignment.service_provider_api.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final UserService userService;
    private final ProfileService profileService;
    private final ClientRepository clientRepository;
    private ClientMapper clientMapper;

    @Autowired
    public ClientService(
            UserService userService,
            ProfileService profileService,
            ClientRepository clientRepository,
            ClientMapper clientMapper
    ) {
        this.userService = userService;
        this.profileService = profileService;
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public ActionResultResponse createClient(ClientCreateRequest clientCreateRequest) {

        User createdUser = userService.createUser(clientCreateRequest, UserRole.CLIENT);
        profileService.createProfile(clientCreateRequest, createdUser.getId());
        clientRepository.save(clientMapper.map(clientCreateRequest, createdUser.getId()));

        return ActionResultResponse.builder()
                .status(true)
                .message("User created with ID: " + createdUser.getId())
                .build();
    }

}
