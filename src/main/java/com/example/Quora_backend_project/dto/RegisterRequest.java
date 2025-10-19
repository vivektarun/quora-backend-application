package com.example.Quora_backend_project.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    @NotBlank(message = "User name is required")
    @Size(min = 3, max = 50, message = "User name must be between 3 and 50 character")
    private String userName;

    @NotBlank(message = "Email is required")
    @Email(message = "must be a valid email address")
    private String email;

    // TODO: make annotation for strong password.
    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 100, message = "Password must be between 6 to 100 character")
    private String password;

    private String bio;
}
