package com.fidenz_assignment.service_provider_api.service;

import com.fidenz_assignment.service_provider_api.dto.request.common.UserRequest;
import com.fidenz_assignment.service_provider_api.enums.UserRole;
import com.fidenz_assignment.service_provider_api.exception.DefaultException;
import com.fidenz_assignment.service_provider_api.mapper.UserMapper;
import com.fidenz_assignment.service_provider_api.model.User;
import com.fidenz_assignment.service_provider_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public <T extends UserRequest> User createUser(T request, UserRole userRole) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user == null) {
            user = userRepository.save(userMapper.map(request, userRole));
            return user;
        } else {
            throw new DefaultException(request.getEmail() + " already have an account");
        }
    }
}
