package com.qubitfaruk.realestateproject.AOP.Attributes.Validation;

import com.qubitfaruk.realestateproject.AOP.CrossCuttingConcerns.Validation.CustomerUpdateValidator;
import com.qubitfaruk.realestateproject.Business.Constants.Messages;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {CustomerUpdateValidator.class})
public @interface CustomerUpdateValidationRules  {
    String message() default Messages.customerEmailMustBeUnique;
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
