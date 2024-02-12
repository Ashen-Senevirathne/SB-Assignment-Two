package com.fidenz_assignment.service_provider_api.service;

import com.fidenz_assignment.service_provider_api.dto.request.common.UserRequest;
import com.fidenz_assignment.service_provider_api.dto.response.AuthenticationResponse;
import com.fidenz_assignment.service_provider_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username);
    }

    public AuthenticationResponse authenticate(UserRequest request) {
        // Need to implement the authentication logic and jwt creation
        return new AuthenticationResponse("Will implement the jwt in next phase", "User login was successful");

    }
}
