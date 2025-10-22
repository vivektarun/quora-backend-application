package com.example.Quora_backend_project.service;

import com.example.Quora_backend_project.dto.RegisterRequest;
import com.example.Quora_backend_project.dto.UserResponse;
import com.example.Quora_backend_project.entity.User;
import com.example.Quora_backend_project.exception.ResourceAlreadyExistsException;
import com.example.Quora_backend_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // Use BCryptPasswordEncoder bean configured in security config

    @Override
    public UserResponse registerUser(RegisterRequest request) {
        // Check for existing email and username
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ResourceAlreadyExistsException("Email already in use");
        }
        if (userRepository.existsByUserName(request.getUserName())) {
            throw new ResourceAlreadyExistsException("Username already taken.");
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        // Build the entity
        User user = User.builder()
                .userName(request.getUserName())
                .firstName(request.getFirstName())
                .middleName(request.getMiddleName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(encodedPassword)
                .bio(request.getBio())
                .build();

        // Save the user
        User savedUser = userRepository.save(user);

        //Map entity to DTO
        return mapToUserResponse(savedUser);
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        return mapToUserResponse(user);
    }

    private UserResponse mapToUserResponse(User user) {
        UserResponse resp = new UserResponse();
        resp.setId(user.getId());
        resp.setUserName(user.getUserName());
        resp.setFirstName(user.getFirstName());
        resp.setMiddleName(user.getMiddleName());
        resp.setLastName(user.getLastName());
        resp.setEmail(user.getEmail());
        resp.setBio(user.getBio());
        return resp;
    }

}
