package com.qubitfaruk.realestateproject.AOP.CrossCuttingConcerns.Validation;

import com.qubitfaruk.realestateproject.AOP.Attributes.Validation.RealEstateFloorRule;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.RealEstate.RealEstateAddDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RealEstateFloorRuleValidator implements ConstraintValidator<RealEstateFloorRule, RealEstateAddDto> {
    @Override
    public boolean isValid(RealEstateAddDto value, ConstraintValidatorContext context) {
        return value.getBuildingFloor() <= value.getNumberOfFloors();
    }
}
