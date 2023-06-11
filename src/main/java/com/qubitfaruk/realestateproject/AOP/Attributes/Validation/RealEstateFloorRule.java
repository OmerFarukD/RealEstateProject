package com.qubitfaruk.realestateproject.AOP.Attributes.Validation;

import com.qubitfaruk.realestateproject.AOP.CrossCuttingConcerns.Validation.RealEstateFloorRuleValidator;
import com.qubitfaruk.realestateproject.Business.Constants.Messages;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {RealEstateFloorRuleValidator.class})
public @interface RealEstateFloorRule {
    String message() default Messages.buildingFloorsLessThanOrEqualNumberOfFloors;

    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
