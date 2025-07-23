package com.shourov.customValidationWithBean.advice;

import com.shourov.customValidationWithBean.exception.InvalidStudentException;
import com.shourov.customValidationWithBean.exception.InvalidTeacherException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    
    @ExceptionHandler(InvalidStudentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleInvalidStudentRequest(InvalidStudentException ex) {
        return Map.of("message", ex.getMessage(), "errors", ex.getErrors());
    }

    @ExceptionHandler(InvalidTeacherException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleInvalidTeacherRequest(InvalidTeacherException ex) {
        return Map.of("message", ex.getMessage(), "errors", ex.getErrors());
    }
}
