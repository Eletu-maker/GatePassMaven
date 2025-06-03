package org.example.services;

import org.example.data.model.Security;
import org.example.data.repository.Securities;
import org.example.dto.request.SecurityRegisterRequest;
import org.example.dto.response.SecurityRegisterResponse;
import org.example.validation.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.example.validation.Validate.validateName;

@Service
public class SecurityServiceImpl implements SecurityService{
    @Autowired
    private Securities securities;

    @Override
    public SecurityRegisterResponse register(SecurityRegisterRequest request) {
        SecurityRegisterResponse securityRegisterResponse = new SecurityRegisterResponse();
        Security security = new Security();
        validateName(request);
        security.setName(request.getName());
        security.setEmail(request.getEmail());
        security.setPassword(request.getPassword());
        security.setPhoneNumber(request.getPhoneNumber());
        securities.save(security);
        securityRegisterResponse.setMessage("Register successful");
        return securityRegisterResponse;
    }
}
