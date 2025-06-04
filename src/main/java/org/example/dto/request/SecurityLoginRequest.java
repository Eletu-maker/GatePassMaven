package org.example.dto.request;

import lombok.Data;

@Data
public class SecurityLoginRequest {
    private String email;
    private String password;
}
