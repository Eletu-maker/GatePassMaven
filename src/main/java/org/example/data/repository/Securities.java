package org.example.data.repository;

import org.example.data.model.Security;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Securities extends MongoRepository<Security,String> {
    Security findByEmail(String email);
}
