package com.fidenz_assignment.service_provider_api.model;

import com.fidenz_assignment.service_provider_api.enums.ExperienceLevel;
import com.fidenz_assignment.service_provider_api.enums.ExperienceType;
import com.fidenz_assignment.service_provider_api.enums.TrainingGoal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ExperienceLevel experienceLevel;

    @Enumerated(EnumType.STRING)
    private ExperienceType experienceType;

    @Enumerated(EnumType.STRING)
    private TrainingGoal trainingGoal;

    private Long userId;
}
