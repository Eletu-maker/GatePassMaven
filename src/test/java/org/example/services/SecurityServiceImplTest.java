package org.example.services;

import org.example.data.repository.Securities;
import org.example.dto.request.SecurityRegisterRequest;
import org.example.dto.response.SecurityRegisterResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class SecurityServiceImplTest {
    @Autowired
    private Securities securities;

    @Test
    public void testThatRegisterSecurity(){

    }

    private SecurityRegisterRequest securityRegisterResponse(){
        SecurityRegisterRequest request = new SecurityRegisterRequest();
        request.setName();
    }

}
