package org.example.data.repository;

import org.example.data.model.Resident;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface Residents extends MongoRepository<Resident, String> {
    Resident findByEmail(String email);

    boolean existsByEmail(String email);
}
