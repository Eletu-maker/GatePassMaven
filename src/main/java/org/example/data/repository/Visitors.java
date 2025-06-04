package org.example.data.repository;

import org.example.data.model.Visitor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Visitors extends MongoRepository<Visitor,String> {
}
