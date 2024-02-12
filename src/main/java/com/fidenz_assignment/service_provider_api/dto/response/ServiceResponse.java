package com.fidenz_assignment.service_provider_api.dto.response;

import com.fidenz_assignment.service_provider_api.enums.ServiceCategory;
import lombok.Data;

@Data
public class ServiceResponse {
    private Long id;
    private Long trainerId;
    private String serviceName;
    private String description;
    private ServiceCategory category;
    private int allowedClients;
    private double pricePerSession;
    private int sessionDuration;
}