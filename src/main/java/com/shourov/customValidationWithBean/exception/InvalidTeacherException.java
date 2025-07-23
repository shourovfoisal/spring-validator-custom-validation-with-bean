package com.shourov.customValidationWithBean.exception;

import lombok.Getter;
import org.springframework.validation.Errors;

import java.util.HashMap;
import java.util.Map;

@Getter
public class InvalidTeacherException extends RuntimeException {
    private final Map<String, Object> errors = new HashMap<>();
    
    public InvalidTeacherException(Errors errors) {
        super("Invalid teacher request body.");
        errors.getFieldErrors().forEach(error -> {
            this.errors.put(error.getField(), error.getDefaultMessage());
        });
    }
}
