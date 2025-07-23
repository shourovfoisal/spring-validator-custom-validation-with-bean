package com.shourov.customValidationWithBean.exception;

import lombok.Getter;
import org.springframework.validation.Errors;

import java.util.HashMap;
import java.util.Map;

@Getter
public class InvalidStudentException extends RuntimeException {
    private final Map<String, Object> errors = new HashMap<>();
    
    public InvalidStudentException(Errors errors) {
        super("Invalid student request body.");
        errors.getFieldErrors().forEach(error -> {
            this.errors.put(error.getField(), error.getDefaultMessage());
        });
    }
}
