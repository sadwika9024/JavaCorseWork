package com.codingshuttle.module2.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Constraint(
        validatedBy = {EmployeeRoleValidator.class}
)
public @interface EmployeeRoleValidation {

    String message() default "role can be user or admin";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};



}
