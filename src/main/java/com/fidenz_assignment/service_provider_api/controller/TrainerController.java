package com.fidenz_assignment.service_provider_api.controller;

import com.fidenz_assignment.service_provider_api.dto.request.TrainerCreateRequest;
import com.fidenz_assignment.service_provider_api.dto.response.ActionResultResponse;
import com.fidenz_assignment.service_provider_api.service.TrainerService;
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
@RequestMapping("/trainer")
@Validated
public class TrainerController {

    private TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createTrainer(@RequestBody @Valid TrainerCreateRequest trainerCreateRequest) {

        ActionResultResponse result = trainerService.createTrainer(trainerCreateRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(result.getMessage());
    }
}
