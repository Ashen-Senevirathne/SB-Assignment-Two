package com.fidenz_assignment.service_provider_api.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActionResultResponse {
    private Boolean status;
    private String message;
}
