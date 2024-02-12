package com.fidenz_assignment.service_provider_api.controller;

import com.fidenz_assignment.service_provider_api.dto.request.common.UserRequest;
import com.fidenz_assignment.service_provider_api.dto.response.AuthenticationResponse;
import com.fidenz_assignment.service_provider_api.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Validated
@RequiredArgsConstructor
public class UserController {

    private final AuthService authService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid UserRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
