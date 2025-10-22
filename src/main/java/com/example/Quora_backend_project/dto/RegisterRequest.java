package com.example.Quora_backend_project.dto;

import com.example.Quora_backend_project.validation.StrongPassword;
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

    @NotBlank(message = "First name is required")
    private String firstName;

    private String middleName;

    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "must be a valid email address")
    private String email;

    @StrongPassword
    private String password;

    private String bio;
}
