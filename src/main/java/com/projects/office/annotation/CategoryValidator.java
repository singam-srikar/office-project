package com.projects.office.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class CategoryValidator implements ConstraintValidator<CategoryValidation, String> {

    @Override
    public boolean isValid(String category, ConstraintValidatorContext constraintValidatorContext) {
        List<String> validList = List.of("IT","Non-IT");
        return validList.contains(category);
    }
}
