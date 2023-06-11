package com.qubitfaruk.realestateproject.AOP.CrossCuttingConcerns.Validation;

import com.qubitfaruk.realestateproject.AOP.Attributes.Validation.CustomerAddValidationRules;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.Customer.CustomerAddDto;
import com.qubitfaruk.realestateproject.Persistence.Contrats.CustomerRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;


public class CustomerAddValidator implements ConstraintValidator<CustomerAddValidationRules, CustomerAddDto> {

    @Autowired
    private  CustomerRepository customerRepository;
    @Override
    public boolean isValid(CustomerAddDto customerAddDto, ConstraintValidatorContext constraintValidatorContext) {
        var data= customerRepository.findAll().stream().filter(x->x.getEmail().equals(customerAddDto.getEmail()))
                .count();
        return data <= 1;
    }
}
