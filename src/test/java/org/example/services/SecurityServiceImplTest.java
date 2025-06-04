package org.example.services;

import org.example.data.model.AccessCode;
import org.example.data.repository.Securities;
import org.example.dto.request.SecurityLoginRequest;
import org.example.dto.request.SecurityRegisterRequest;
import org.example.dto.response.SecurityLoginResponse;
import org.example.dto.response.SecurityRegisterResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class SecurityServiceImplTest {
    @Autowired
    private SecurityServiceImpl securities;

    @Test
    public void testThatRegisterSecurity(){
        SecurityRegisterRequest request = securityRegister();
        SecurityRegisterResponse securityRegisterResponse = securities.register(request);
        assertEquals("Register successful",securityRegisterResponse.getMessage());


    }

    private SecurityRegisterRequest securityRegister(){
        SecurityRegisterRequest request = new SecurityRegisterRequest();
        request.setName("idowu");
        request.setEmail("mdidowu@gmail.com");
        request.setPassword("idowu123");
        request.setPhoneNumber("09134969393");
        return request;

    }

    @Test
    public void testLoginSecurity(){
        SecurityLoginRequest request = securityLoginRequest();
        SecurityLoginResponse response = securities.login(request);
        assertEquals("Login successful",response.getMessage());
    }

    private SecurityLoginRequest securityLoginRequest(){
        SecurityLoginRequest request = new SecurityLoginRequest();
        request.setEmail("mdidowu@gmail.com");
        request.setPassword("idowu123");
        return request;
    }

    @Test
    public void testVerifyAccessCode(){
        AccessCode accessCode = new AccessCode();
        accessCode.setId("683f91b1d65028d283fd8418");
        accessCode.setToken("33770");
        securities.verifyAccessCode(accessCode);

        assertTrue(accessCode.isUsed());

    }



}
