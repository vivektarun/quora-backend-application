package com.example.Quora_backend_project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private Long id;
    private String userName;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String bio;
}
