package org.example.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Visitor")
public class Visitor {
    @Id
    private String id;
    private String name;
    private String phoneNumber;


}


