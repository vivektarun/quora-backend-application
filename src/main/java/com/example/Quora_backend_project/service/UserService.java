package com.example.Quora_backend_project.service;

import com.example.Quora_backend_project.dto.RegisterRequest;
import com.example.Quora_backend_project.dto.UserResponse;

public interface UserService {
    UserResponse registerUser(RegisterRequest request);
    UserResponse getUserById(Long id);
}
