package com.fidenz_assignment.service_provider_api.mapper;

import com.fidenz_assignment.service_provider_api.dto.request.TrainerCreateRequest;
import com.fidenz_assignment.service_provider_api.model.Trainer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrainerMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public TrainerMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Trainer map(TrainerCreateRequest TrainerCreateRequest, Long userId) {
        Trainer Trainer = modelMapper.map(TrainerCreateRequest, Trainer.class);
        Trainer.setUserId(userId);
        return Trainer;
    }
}
