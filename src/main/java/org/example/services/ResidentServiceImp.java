package org.example.services;

import org.example.data.model.Visitor;
import org.example.dto.request.GenerateAccessCodeRequest;
import org.example.dto.request.ResidentLoginRequest;
import org.example.dto.request.ResidentRegisterRequest;
import org.example.dto.response.AccessCodeResponse;
import org.example.dto.response.ResidentLoginResponse;
import org.example.dto.response.ResidentRegisterResponse;

public interface ResidentServiceImp {
    ResidentRegisterResponse register(ResidentRegisterRequest request);
    ResidentLoginResponse login(ResidentLoginRequest request);
    AccessCodeResponse generateToken(GenerateAccessCodeRequest request, Visitor visitor);
}
