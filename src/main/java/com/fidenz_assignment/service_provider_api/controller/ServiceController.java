package com.fidenz_assignment.service_provider_api.controller;

import com.fidenz_assignment.service_provider_api.dto.request.SearchRequest;
import com.fidenz_assignment.service_provider_api.dto.request.ServiceCreateRequest;
import com.fidenz_assignment.service_provider_api.dto.response.ServiceResponse;
import com.fidenz_assignment.service_provider_api.service.ServiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service")
@RequiredArgsConstructor
public class ServiceController {
    private final ServiceService serviceService;

    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> createService(@RequestBody @Valid ServiceCreateRequest serviceCreateRequest) {
        ServiceResponse serviceResponse = serviceService.createService(serviceCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceResponse);
    }

    @PostMapping("/search")
    public ResponseEntity<List<ServiceResponse>> searchServices(@RequestBody @Valid SearchRequest searchRequest) {
        List<ServiceResponse> services = serviceService.searchServices(searchRequest);
        return ResponseEntity.ok(services);
    }
}
