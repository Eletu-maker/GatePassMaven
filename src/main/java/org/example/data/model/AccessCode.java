package org.example.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Data
@Document("AccessCodes")
public class AccessCode {
    private String token;
    @Id
    private String id;
    @DBRef
    private Resident WhomToSee;
    private LocalDateTime timeCreated =LocalDateTime.now();
    private LocalDateTime expireTime = LocalDateTime.now().plusDays(1);
    private boolean used ;
    @DBRef
    private Visitor visitor;

}