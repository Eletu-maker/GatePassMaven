package org.example.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Visitor")
public class Visitor {
    public String token;
    private String name;
    private String phoneNumber;
    private String email;

}


