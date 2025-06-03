package org.example.dto.request;

import lombok.Data;

@Data
public class ResidentLoginRequest {
    private String email;
    private String password;
}
