package com.fidenz_assignment.service_provider_api.repository;

import com.fidenz_assignment.service_provider_api.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
