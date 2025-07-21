package com.shourov.customValidationWithBean.validator;

import com.shourov.customValidationWithBean.dto.Student;
import jakarta.annotation.Nonnull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class StudentValidator implements Validator {
    @Override
    public boolean supports(@Nonnull Class<?> clazz) {
        return Student.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Student student = (Student) target;
        
        if(student.getAge() < 18) {
            errors.rejectValue("age", "student.age.min", "Student must be at least 18 years old.");
        }
    }
}
