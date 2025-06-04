package org.example.services;

import org.example.data.model.AccessCode;
import org.example.data.model.Security;
import org.example.data.repository.AccessCodes;
import org.example.data.repository.Securities;
import org.example.dto.request.SecurityLoginRequest;
import org.example.dto.request.SecurityRegisterRequest;
import org.example.dto.response.SecurityLoginResponse;
import org.example.dto.response.SecurityRegisterResponse;
import org.example.exception.ExistingSecurity;
import org.example.exception.IncorrectPassword;
import org.example.exception.TokenError;
import org.example.exception.TokenUsed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static org.example.validation.Validate.*;

@Service
public class SecurityServiceImpl implements SecurityService{


    @Autowired
    private Securities securities;

    @Autowired
    private AccessCodes accessCodes;

    @Override
    public SecurityRegisterResponse register(SecurityRegisterRequest request) {
        SecurityRegisterResponse securityRegisterResponse = new SecurityRegisterResponse();
        if (securities.existsByEmail(request.getEmail())) throw new ExistingSecurity("Security already registered");
        else save(request);
        securityRegisterResponse.setMessage("Register successful");
        return securityRegisterResponse;
    }

    @Override
    public SecurityLoginResponse login(SecurityLoginRequest request) {
        SecurityLoginResponse securityLoginResponse = new SecurityLoginResponse();
        Security security= securities.findByEmail(request.getEmail());
        if(!security.getPassword().equals(request.getPassword())){
            throw new IncorrectPassword("Wrong password");
        }
        security.setLogin(true);
        securities.save(security);
        securityLoginResponse.setMessage("Login successful");
        return securityLoginResponse;
    }

    private void save(SecurityRegisterRequest request){
        Security security = new Security();
        validateName(request);
        security.setName(request.getName());
        validateEmail(request);
        security.setEmail(request.getEmail());
        validatePassword(request);
        security.setPassword(request.getPassword());
        validatePhone(request);
        security.setPhoneNumber(request.getPhoneNumber());
        securities.save(security);
    }

    @Override
    public void verifyAccessCode(AccessCode accessCode) {
    if(accessCodes.existsByToken(accessCode.getToken()))findAccessCode(accessCode);
    else throw new TokenError("Token do not exist");
    }


    private void findAccessCode(AccessCode accessCode){
        checkExpiredAccessCode(accessCode);
        AccessCode findaccessCode = accessCodes.findAccessCodeByToken(accessCode.getToken());
        if (findaccessCode.isUsed()) {throw new TokenUsed("token has been used already");}
        else{ findaccessCode.setUsed(true);
            System.out.println(findaccessCode.isUsed());
        accessCodes.save(findaccessCode);}
    }

    private void checkExpiredAccessCode(AccessCode accessCode){
        LocalDateTime now = LocalDateTime.now();
        AccessCode findaccessCode = accessCodes.findAccessCodeByToken(accessCode.getToken());
        LocalDateTime expireTime = findaccessCode.getExpireTime();
        if(now.isAfter(expireTime))throw new TokenUsed("Token already expired");
    }
}
