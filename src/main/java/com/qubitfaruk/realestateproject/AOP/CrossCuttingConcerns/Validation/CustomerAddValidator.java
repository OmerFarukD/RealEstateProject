package com.qubitfaruk.realestateproject.AOP.CrossCuttingConcerns.Validation;

import com.qubitfaruk.realestateproject.AOP.Attributes.Validation.CustomerAddValidationRules;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.Customer.CustomerAddDto;
import com.qubitfaruk.realestateproject.Persistence.Contrats.CustomerRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerValidator implements ConstraintValidator<CustomerAddValidationRules, CustomerAddDto> {

    private final CustomerRepository customerRepository;
    @Override
    public boolean isValid(CustomerAddDto customerAddDto, ConstraintValidatorContext constraintValidatorContext) {

        var data= customerRepository.countCustomerByEmail(customerAddDto.email());
        return data <= 1;
    }
}
