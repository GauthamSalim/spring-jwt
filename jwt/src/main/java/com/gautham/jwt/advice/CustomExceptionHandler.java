package com.gautham.jwt.advice;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;

@RestControllerAdvice
public class CustomExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleSecurityException(Exception e){
        ResponseEntity<String> entity = null;
        if(e instanceof BadCredentialsException){
           entity = ResponseEntity.status(401).body("Invalid credentials");
        }
        if (e instanceof AccessDeniedException) {
            entity = ResponseEntity.status(403).body("Not authorized to access this resource");
        }

        if (e instanceof SignatureException) {
            entity = ResponseEntity.status(401).body("Invalid token");
        }

        if (e instanceof ExpiredJwtException) {
            entity = ResponseEntity.status(401).body("Token has expired");
        }
        System.err.println(e);
        return entity;
    }
}
