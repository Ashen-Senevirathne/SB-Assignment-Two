package com.fidenz_assignment.service_provider_api.dto.request;

import com.fidenz_assignment.service_provider_api.dto.request.common.ProfileRequest;
import com.fidenz_assignment.service_provider_api.enums.ExperienceLevel;
import com.fidenz_assignment.service_provider_api.enums.ExperienceType;
import com.fidenz_assignment.service_provider_api.enums.TrainingGoal;
import lombok.Data;

@Data
public class ClientCreateRequest extends ProfileRequest {
    private ExperienceLevel experienceLevel;
    private ExperienceType experienceType;
    private TrainingGoal trainingGoal;
}
