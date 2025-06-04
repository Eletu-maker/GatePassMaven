package org.example.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Data
@Document("Visitor")
public class Visitor {
    @Id
    private String id;

    private String phoneNumber;


    @Override
    public  boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visitor that = (Visitor) o;
        return Objects.equals(phoneNumber,that.phoneNumber);
    }
}


