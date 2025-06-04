package org.example.services;

import org.example.data.model.Visitor;
import org.example.dto.request.GenerateAccessCodeRequest;
import org.example.dto.request.ResidentLoginRequest;
import org.example.dto.request.ResidentRegisterRequest;
import org.example.dto.response.AccessCodeResponse;
import org.example.dto.response.ResidentLoginResponse;
import org.example.dto.response.ResidentRegisterResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class ResidentServiceTest {
    @Autowired
    private ResidentService residentService;



    @Test
    public void testThatRegisterResident(){
        ResidentRegisterRequest Request = registerResident();
        ResidentRegisterResponse registerPersonResponse = residentService.register(Request) ;
        assertEquals("Resident register successful",registerPersonResponse.getMessage());


    }

    private ResidentRegisterRequest registerResident(){
        ResidentRegisterRequest request = new ResidentRegisterRequest();
        request.setName("eric");
        request.setEmail("ericalli@gmail.com");
        request.setPhoneNumber("07033472262");
        request.setPassword("Magic009");
        return request;
    }

    @Test
    public void testLoginResident(){
        ResidentLoginRequest request = loginRequest();
        ResidentLoginResponse response = residentService.login(request);
        assertEquals("Login successful", response.getMessages());
    }

    private ResidentLoginRequest loginRequest(){
        ResidentLoginRequest residentLoginRequest = new ResidentLoginRequest();
        residentLoginRequest.setEmail("ericalli@gmail.com");
        residentLoginRequest.setPassword("Magic009");
        return residentLoginRequest;
    }

    @Test
    public void testGenerateToken(){
        GenerateAccessCodeRequest generateAccessCodeRequest= new GenerateAccessCodeRequest();
        AccessCodeResponse accessCodeResponse = residentService.generateToken(generateAccessCodeRequest,dVisitor());
        assertEquals("Token generated",accessCodeResponse.getMessage());


    }

    private Visitor dVisitor(){
        Visitor visitor = new Visitor();
        visitor.setPhoneNumber("09134969393");
        return visitor;
    }


}