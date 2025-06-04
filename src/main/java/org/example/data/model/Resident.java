package org.example.data.model;

import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@Document("Residents")
public class Resident extends User {
    @Id
    private String id ;
    private String address;







}
