package com.fidenz_assignment.service_provider_api.repository;

import com.fidenz_assignment.service_provider_api.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}