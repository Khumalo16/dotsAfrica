package com.dotsafrica.dotsafrica.exception;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.validation.ConstraintViolationException;


/**
 * @author Ismail
 * 
 * A customise exception handler class
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private Set<String> error;
    
    public GlobalExceptionHandler() {
        
        error = new HashSet<>();
        error.add("Label is blank");
        error.add("Description is blank");
        error.add("Username field should not be null  or empty");       
    } 
    /**
     * Handle IllegalStateException
     * 
     * @param e the exception
     * @return a customise error message
     */
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Object> illegatStatementException(IllegalStateException e) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", System.currentTimeMillis());
        body.put("status", 500);
        
        String errors  = e.getMessage();
        body.put("message", errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
    
    /**
     * Handle ConstraintViolationException
     * 
     * @param e the exception
     * @param httpStatus status of the request
     * @return a customise error message
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> illegatStatementEsxception(ConstraintViolationException e) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", System.currentTimeMillis());
        body.put("status", HttpStatus.BAD_GATEWAY);
        
        List<String> errors = new ArrayList<>();

        // append in the list all error messages
        
        for (String error : error) {
            if (e.getMessage().contains(error))
             errors.add(error);         
        }
        body.put("message", errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
