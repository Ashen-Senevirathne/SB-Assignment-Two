package com.fidenz_assignment.service_provider_api.dto.request;

import com.fidenz_assignment.service_provider_api.dto.request.common.ProfileRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TrainerCreateRequest extends ProfileRequest {

    @NotBlank(message = "Business location required.")
    private String businessLocation;

    @NotBlank(message = "Telephone required.")
    private String telephone;

    @NotBlank(message = "Brand name required.")
    private String brandName;
}
