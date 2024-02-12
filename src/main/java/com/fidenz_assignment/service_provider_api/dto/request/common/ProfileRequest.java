package com.fidenz_assignment.service_provider_api.dto.request.common;

import com.fidenz_assignment.service_provider_api.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileRequest extends UserRequest {
    @NotBlank(message = "First name required.")
    private String firstName;

    @NotBlank(message = "Last name required.")
    private String lastName;

    @NotBlank(message = "Address required.")
    private String address;

    @Past
    private LocalDate birthday;

    private Gender gender;

    @NotBlank(message = "Language required.")
    private String language;
}
