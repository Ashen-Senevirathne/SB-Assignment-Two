package com.fidenz_assignment.service_provider_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String businessLocation;
    private String telephone;
    private String brandName;
    private Long userId;

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
    private List<Service> services;
}
