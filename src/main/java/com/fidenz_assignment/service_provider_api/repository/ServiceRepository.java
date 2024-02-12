package com.fidenz_assignment.service_provider_api.repository;

import com.fidenz_assignment.service_provider_api.enums.ServiceCategory;
import com.fidenz_assignment.service_provider_api.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    List<Service> findByPricePerSessionBetweenAndCategory(double minPrice, double maxPrice, ServiceCategory category);
}