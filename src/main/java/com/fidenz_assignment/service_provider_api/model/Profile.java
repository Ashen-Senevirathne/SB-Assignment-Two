package com.fidenz_assignment.service_provider_api.model;

import com.fidenz_assignment.service_provider_api.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String address;
    private LocalDate birthday;
    private String language;
    private Long userId;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
