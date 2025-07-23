package com.shourov.customValidationWithBean.controller;

import com.shourov.customValidationWithBean.dto.Student;
import com.shourov.customValidationWithBean.exception.InvalidStudentException;
import com.shourov.customValidationWithBean.validator.StudentValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    
    private final StudentValidator validator;
    
    @PostMapping
    public ResponseEntity<Student> saveStudent(@Valid @ModelAttribute Student student, BindingResult result) {
        validator.validate(student, result);
        
        if(result.hasErrors()) {
            log.error("Invalid request body");
            throw new InvalidStudentException(result);
        }
        
        return ResponseEntity.ok(student);
    }
    
}
