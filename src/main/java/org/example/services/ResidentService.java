package org.example.services;

import org.example.data.model.AccessCode;
import org.example.data.model.Resident;
import org.example.data.model.Visitor;
import org.example.data.repository.AccessCodes;
import org.example.data.repository.Residents;
import org.example.data.repository.Visitors;
import org.example.dto.request.GenerateAccessCodeRequest;
import org.example.dto.request.ResidentLoginRequest;
import org.example.dto.request.ResidentRegisterRequest;
import org.example.dto.response.AccessCodeResponse;
import org.example.dto.response.ResidentLoginResponse;
import org.example.dto.response.ResidentRegisterResponse;
import org.example.exception.ExistingResident;
import org.example.exception.IncorrectPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

import static org.example.validation.Validate.*;


@Service
public class ResidentService implements ResidentServiceImp{
    @Autowired
    private Residents residents;
    @Autowired
    private AccessCodes accessCodes;
    @Autowired
    private Visitors visitors;

    @Override
    public ResidentRegisterResponse register(ResidentRegisterRequest request) {
        ResidentRegisterResponse response = new ResidentRegisterResponse();
        if(residents.existsByEmail(request.getEmail())) throw  new ExistingResident("Resident already exist");
        else save(request);
        response.setMessage("Resident register successful");
        return response;

    }

    private void save(ResidentRegisterRequest request){
        Resident resident = new Resident();
        validateName(request);
        resident.setName(request.getName());
        validatePassword(request);
        resident.setPassword(request.getPassword());
        validateEmail(request);
        resident.setEmail(request.getEmail());
        validatePhone(request);
        resident.setPhoneNumber(request.getPhoneNumber());
        resident.setId(request.getId());
        residents.save(resident);
    }


    @Override
    public ResidentLoginResponse login(ResidentLoginRequest request) {
        ResidentLoginResponse response = new ResidentLoginResponse();
        Resident resident = residents.findByEmail(request.getEmail());
        if(!resident.getPassword().equals(request.getPassword())){
            throw new IncorrectPassword("Wrong password");
        }
        resident.setLogin(true);
        residents.save(resident);
        response.setMessages("Login successful");

        return response;

    }


    @Override
    public AccessCodeResponse generateToken(GenerateAccessCodeRequest request, Visitor visitor) {
        AccessCodeResponse accessCodeResponse = new AccessCodeResponse();
        AccessCode accessCode = new AccessCode();
        if (visitor.getId() == null) {
            visitor = visitors.save(visitor);
        }
        accessCode.setWhomToSee(request.getWhomToSee());
        validateVisitorPhone(visitor);
        accessCode.setVisitor(visitor);

        accessCode.setTimeCreated(request.getTimeCreated());
        accessCode.setExpireTime(request.getExpireTime());
        accessCode.setUsed(request.isUsed());
        String token;
        do {
            token = getOtp();
        } while (accessCodes.existsByToken(token));
        accessCode.setToken(getOtp());
        //accessCode.setId(request.getWhomToSee().getId());
        accessCodeResponse.setMessage("Token generated");
        accessCodes.save(accessCode);
        return accessCodeResponse;
    }

    private String getOtp() {
        String otp = "";
        for (int count = 0; count < 5; count++) {
            char[] chars = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
            Random rand = new Random();
            int randomNumber = rand.nextInt(10);
            otp += chars[randomNumber];

        }
        return otp;
    }


}
