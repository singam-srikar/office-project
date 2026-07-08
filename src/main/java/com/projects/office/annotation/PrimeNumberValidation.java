package com.projects.office.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {PrimeNumberValidator.class})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface PrimeNumberValidation {
    String message() default "Please enter non prime number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}