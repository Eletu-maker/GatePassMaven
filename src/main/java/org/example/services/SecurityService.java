package org.example.services;

import org.example.dto.request.SecurityRegisterRequest;
import org.example.dto.response.SecurityRegisterResponse;

public interface SecurityService {
    SecurityRegisterResponse register(SecurityRegisterRequest request);

}
