package com.fidenz_assignment.service_provider_api.mapper;

import com.fidenz_assignment.service_provider_api.dto.request.ServiceCreateRequest;
import com.fidenz_assignment.service_provider_api.dto.response.ServiceResponse;
import com.fidenz_assignment.service_provider_api.model.Service;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServiceMapper {
    private final ModelMapper modelMapper;

    public ServiceResponse map(Service service) {
        return modelMapper.map(service, ServiceResponse.class);
    }

    public Service map(ServiceCreateRequest serviceCreateRequest) {
        return modelMapper.map(serviceCreateRequest, Service.class);
    }
}
