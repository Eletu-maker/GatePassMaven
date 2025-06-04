package org.example.services;

import org.example.data.model.AccessCode;
import org.example.data.model.Visitor;
import org.example.data.repository.AccessCodes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class VisitorServiceImplTest {
    @Autowired
    private VisitorService visitorService;

    @Test
    public void testViewAccesCode(){
        AccessCode accessCode = visitorService.viewAccessCode("31242",dVisitor());
        assertNotNull(accessCode);
    }


    private Visitor dVisitor(){
        Visitor visitor = new Visitor();
        visitor.setPhoneNumber("09134969393");
        return visitor;
    }
}