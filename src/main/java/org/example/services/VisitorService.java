package org.example.services;

import org.example.data.model.AccessCode;
import org.example.data.model.Visitor;

public interface VisitorService {
    AccessCode viewAccessCode(String token, Visitor visitor);
}
