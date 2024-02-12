package com.fidenz_assignment.service_provider_api.dto.request;

import com.fidenz_assignment.service_provider_api.enums.ServiceCategory;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SearchRequest {
    @NotNull(message = "Min price required.")
    @Min(value = 0, message = "Min price can not be negative.")
    private Double minPrice;

    @NotNull(message = "Max price required.")
    @Min(value = 0, message = "Max price can not be negative.")
    private Double maxPrice;

    private ServiceCategory category;
}
