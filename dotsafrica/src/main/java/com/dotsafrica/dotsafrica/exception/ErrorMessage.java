package com.dotsafrica.dotsafrica.exception;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class ErrorMessage {

    private Set<String> error;
    
    public ErrorMessage() {
      
        error.add("username field should not be null  or empty");
        error.add("username field should not be null  or empty");

        
    } }