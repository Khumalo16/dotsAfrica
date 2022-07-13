package com.dotsafrica.dotsafrica.exception;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class ErrorMessage {

    private Set<String> error;
    
    public ErrorMessage() {
        error = new HashSet<>();
        error.add("First name field should not be null  or empty");
        error.add("Last name field should not be null or empty");
        error.add("ussername field should not be null  or empty");
        error.add("Email format is not valid");
        error.add("Password field should not be null");
        error.add("Email field should not ve null or empty");
    } }