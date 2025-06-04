package org.example.controller;
/*
import org.example.dto.request.ResidentRegisterRequest;
import org.example.dto.response.ApiResponse;
import org.example.dto.response.ResidentRegisterResponse;
import org.example.services.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.RelationService;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private ResidentService residentService;

    @PostMapping("/registerResident")
    public ResponseEntity<?> registerResident(ResidentRegisterRequest request){
        try{
            ResidentRegisterResponse response = residentService.register(request);
            return new ResponseEntity<>(new ApiResponse(true,response), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}


 */