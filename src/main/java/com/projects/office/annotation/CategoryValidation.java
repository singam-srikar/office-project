package com.projects.office.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CategoryValidator.class})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CategoryValidation {
    String message() default "Role can be IT or Non-IT";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
