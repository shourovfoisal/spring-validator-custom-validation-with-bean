package com.shourov.customValidationWithBean.controller;

import com.shourov.customValidationWithBean.dto.Teacher;
import com.shourov.customValidationWithBean.exception.InvalidTeacherException;
import com.shourov.customValidationWithBean.validator.TeacherValidator;
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
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {
    
    private final TeacherValidator validator;
    
    @PostMapping
    public ResponseEntity<Teacher> saveTeacher(@Valid @ModelAttribute Teacher teacher, BindingResult result) {
        validator.validate(teacher, result);
        
        if(result.hasErrors()) {
            log.error("Invalid request body");
            throw new InvalidTeacherException(result);
        }
        
        return ResponseEntity.ok(teacher);
    }
}
