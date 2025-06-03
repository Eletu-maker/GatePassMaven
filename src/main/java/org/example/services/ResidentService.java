package org.example.servives;

import org.example.data.model.Resident;
import org.example.data.repository.Residents;
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
        residents.save(resident);
    }


    @Override
    public ResidentLoginResponse login(ResidentLoginRequest request) {
        ResidentLoginResponse response = new ResidentLoginResponse();
        Resident resident = residents.findByEmail(request.getEmail());
        if(!resident.getPassword().equals(request.getPassword())){
            throw new IncorrectPassword("Wrong password");
        }
        resident.setLogIn(true);
        residents.save(resident);
        response.setMessages("Login successful");

        return response;

    }


    @Override
    public AccessCodeResponse generateToken(GenerateAccessCodeRequest request) {
        AccessCodeResponse accessCodeResponse = new AccessCodeResponse();
        accessCodeResponse.setWhomToSee(request.getWhomToSee());
        accessCodeResponse.setVisitor(request.getVisitor());

        String otp = "";
        for (int count=0; count<5; count++) {
            char[] chars = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
            Random rand = new Random();
            int randomNumber = rand.nextInt(10);
            otp += chars[randomNumber];
        }
        accessCodeResponse.setToken(otp);
        accessCodeResponse.setTimeCreated(request.getTimeCreated());
        accessCodeResponse.setExpireTime(request.getExpireTime());
        accessCodeResponse.setActive(request.isActive());
        accessCodeResponse.setMessage("Token generated");

        return accessCodeResponse;
    }




}
