package com.shourov.customValidationWithBean.validator;

import com.shourov.customValidationWithBean.dto.Teacher;
import jakarta.annotation.Nonnull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TeacherValidator implements Validator {
    @Override
    public boolean supports(@Nonnull Class<?> clazz) {
        return Teacher.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Teacher teacher = (Teacher) target;
        if(teacher.getExperience() < 3) {
            errors.rejectValue("experience", "teacher.experience.min", "Teacher must have at least 3 years of experience.");
        }
    }
}
