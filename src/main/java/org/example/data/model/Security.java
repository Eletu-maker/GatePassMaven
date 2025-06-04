package org.example.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Security")
public class Security extends User{
    @Id
    private String id ;




}
