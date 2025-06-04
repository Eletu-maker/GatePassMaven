package org.example.data.repository;

import org.example.data.model.AccessCode;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccessCodes extends MongoRepository<AccessCode,String> {
    boolean existsByToken(String token);
    AccessCode findAccessCodeByToken(String token);
    AccessCode findAccessCodeByVisitorPhoneNumber(String number);
}
