package com.fidenz_assignment.service_provider_api.service;

import com.fidenz_assignment.service_provider_api.dto.request.SearchRequest;
import com.fidenz_assignment.service_provider_api.dto.request.ServiceCreateRequest;
import com.fidenz_assignment.service_provider_api.dto.response.ServiceResponse;
import com.fidenz_assignment.service_provider_api.exception.DefaultException;
import com.fidenz_assignment.service_provider_api.mapper.ServiceMapper;
import com.fidenz_assignment.service_provider_api.model.Service;
import com.fidenz_assignment.service_provider_api.repository.ServiceRepository;
import com.fidenz_assignment.service_provider_api.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceService {
    private final ServiceRepository serviceRepository;
    private final TrainerRepository trainerRepository;
    private final ServiceMapper serviceMapper;

    public ServiceResponse createService(ServiceCreateRequest serviceCreateRequest) {
        trainerRepository.findById(serviceCreateRequest.getTrainerId())
                .orElseThrow(() -> new DefaultException("Trainer not found with id: " + serviceCreateRequest.getTrainerId()));

        Service service = serviceMapper.map(serviceCreateRequest);
        return serviceMapper.map(serviceRepository.save(service));
    }

    public List<ServiceResponse> searchServices(SearchRequest searchRequest) {
        List<Service> services = serviceRepository.findByPricePerSessionBetweenAndCategory(searchRequest.getMinPrice(), searchRequest.getMaxPrice(), searchRequest.getCategory());
        return services.stream()
                .map(serviceMapper::map)
                .collect(Collectors.toList());
    }
}