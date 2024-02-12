package com.fidenz_assignment.service_provider_api.dto.request;

import com.fidenz_assignment.service_provider_api.enums.ServiceCategory;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ServiceCreateRequest {
    @NotNull(message = "Trainer id required.")
    private Long trainerId;

    @NotBlank(message = "Service name can not be empty.")
    private String serviceName;

    private String description;

    @Enumerated
    private ServiceCategory category;

    @Min(value = 0, message = "Allowed clients number can not be negative.")
    private int allowedClients;

    @Min(value = 0, message = "Price per session can not be negative.")
    private double pricePerSession;

    @Min(value = 0, message = "Session duration can not be negative.")
    private int sessionDuration;
}