package com.qubitfaruk.realestateproject.AOP.Attributes.Validation;

import com.qubitfaruk.realestateproject.AOP.CrossCuttingConcerns.Validation.CustomerValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {CustomerValidator.class})


public @interface CustomerValidationRules {
    String message() default "";

    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}
