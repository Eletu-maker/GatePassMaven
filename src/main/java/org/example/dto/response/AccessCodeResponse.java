package org.example.dto.response;

import lombok.Data;
import org.example.data.model.Resident;
import org.example.data.model.Visitor;

import java.time.LocalDate;

@Data
public class AccessCodeResponse {
    private String id;
    private String token;
    private Resident WhomToSee;
    private Visitor visitor;
    private LocalDate timeCreated;
    private LocalDate expireTime;
    private String message;
    private boolean active = false ;
}
