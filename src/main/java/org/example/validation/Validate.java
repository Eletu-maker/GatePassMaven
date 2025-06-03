package org.example.validation;

import org.example.dto.request.ResidentRegisterRequest;
import org.example.exception.Email;
import org.example.exception.Name;
import org.example.exception.Password;
import org.example.exception.PhoneNumber;

public class Validate {
    public static void validateName(ResidentRegisterRequest request){
        if(request.getName().isEmpty()){
            throw new Name("please enter your name");
        }
    }

    public static void validatePassword(ResidentRegisterRequest request){
        if(request.getPassword().length()<5){
            throw new Password("password must be 5 letter above");
        }
    }

    public static void validatePhone(ResidentRegisterRequest request){
        if(request.getPhoneNumber().length() != 11){
            throw new PhoneNumber("phone number must be 11 digits");
        }
    }

    public static void validateEmail(ResidentRegisterRequest request){
        if (!request.getEmail().contains("@gmail.com")){
            throw new Email("invalid email");
        }
    }
}
