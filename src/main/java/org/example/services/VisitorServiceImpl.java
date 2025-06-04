package org.example.services;

import org.example.data.model.AccessCode;
import org.example.data.model.Visitor;
import org.example.data.repository.AccessCodes;
import org.example.exception.TokenError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorServiceImpl implements VisitorService{
    @Autowired
    private AccessCodes accessCodes;
    @Override
    public AccessCode viewAccessCode(String token , Visitor visitor) {
        AccessCode accessCode =  accessCodes.findAccessCodeByToken(token);
        if(!accessCode.getVisitor().equals(visitor)){
            throw new TokenError("invalid visitor");
        }
        return accessCode;
    }
}
