package org.example.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Security")
public class Security {
    private String name;
    @Id
    private String id ;
    private String phoneNumber;
    private String email;
    private String password;



}
