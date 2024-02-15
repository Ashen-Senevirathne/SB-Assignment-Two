package com.fidenz_assignment.service_provider_api.repository;

import com.fidenz_assignment.service_provider_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
