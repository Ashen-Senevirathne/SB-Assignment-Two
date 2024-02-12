package com.fidenz_assignment.service_provider_api.controller;

import com.fidenz_assignment.service_provider_api.dto.request.ClientCreateRequest;
import com.fidenz_assignment.service_provider_api.dto.response.ActionResultResponse;
import com.fidenz_assignment.service_provider_api.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@Validated
public class ClientController {

    private final ClientService clientService;

    @Autowired
    ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createClient(@RequestBody @Valid ClientCreateRequest clientCreateRequest) {
        ActionResultResponse result = clientService.createClient(clientCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(result.getMessage());
    }
}
