package org.example.data.repository;

import org.example.data.model.Resident;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class ResidentsTest {
    @Autowired
    private Residents residents;


    @BeforeEach
    public void setup(){
        residents.deleteAll();
    }
  @Test
    public void testsaveMethod(){
      Resident resident = new Resident();
      resident.setName("eric");
      resident.setPhoneNumber("09134969393");
      resident.setEmail("ydfuvx@gmail.com");
      resident.setPassword("ydajyhs");
      residents.save(resident);
      assertEquals(1,residents.count());
  }


}