package org.example.services;

import org.example.data.model.AccessCode;
import org.example.dto.request.SecurityLoginRequest;
import org.example.dto.request.SecurityRegisterRequest;
import org.example.dto.response.SecurityLoginResponse;
import org.example.dto.response.SecurityRegisterResponse;

public interface SecurityService {
    SecurityRegisterResponse register(SecurityRegisterRequest request);
    SecurityLoginResponse login(SecurityLoginRequest request);
    void verifyAccessCode(AccessCode accessCode);

}
