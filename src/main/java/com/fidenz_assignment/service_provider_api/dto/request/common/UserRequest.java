package com.fidenz_assignment.service_provider_api.dto.request.common;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {

    @Email(message = "Please enter valid email.")
    private String email;

    @NotBlank(message = "Password required.")
    private String password;
}
