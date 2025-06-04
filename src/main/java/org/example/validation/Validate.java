package org.example.validation;

import org.example.data.model.User;
import org.example.data.model.Visitor;
import org.example.dto.request.ResidentRegisterRequest;
import org.example.exception.Email;
import org.example.exception.Name;
import org.example.exception.Password;
import org.example.exception.PhoneNumber;

public class Validate {
    public static void validateName(User request){
        if(request.getName().isEmpty()){
            throw new Name("please enter your name");
        }
    }

    public static void validatePassword(User request){
        if(request.getPassword().length()<5){
            throw new Password("password must be 5 letter above");
        }
    }

    public static void validateVisitorPhone(Visitor visitor){
        if(visitor.getPhoneNumber().length() != 11){
            throw new PhoneNumber("phone number must be 11 digits");
        }


    }

    public static void validatePhone(User request){
        if(request.getPhoneNumber().length() != 11){
            throw new PhoneNumber("phone number must be 11 digits");
        }


    }

    public static void validateEmail(User request){
        if (!request.getEmail().contains("@gmail.com")){
            throw new Email("invalid email");
        }
    }
}
