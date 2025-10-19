package com.example.Quora_backend_project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private long id;
    private String userName;
    private String email;
    private String bio;
}
