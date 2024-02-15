package com.fidenz_assignment.service_provider_api.mapper;

import com.fidenz_assignment.service_provider_api.dto.request.ClientCreateRequest;
import com.fidenz_assignment.service_provider_api.model.Client;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientMapper {
    private final ModelMapper modelMapper;

    public Client map(ClientCreateRequest clientCreateRequest, Long userId) {
        Client client = modelMapper.map(clientCreateRequest, Client.class);
        client.setUserId(userId);
        return client;
    }
}
