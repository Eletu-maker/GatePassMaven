package org.example.data.model;

import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@Document("Residents")
public class Resident {
    private String name;
    @Id
    private String id ;
    private String phoneNumber;
    private String email;
    private String password;
    private  boolean logIn;
    private String address;







}
