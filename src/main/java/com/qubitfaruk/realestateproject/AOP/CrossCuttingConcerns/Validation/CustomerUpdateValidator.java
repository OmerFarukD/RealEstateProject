package com.qubitfaruk.realestateproject.AOP.CrossCuttingConcerns.Validation;

import com.qubitfaruk.realestateproject.AOP.Attributes.Validation.CustomerUpdateValidationRules;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.Customer.CustomerUpdateDto;
import com.qubitfaruk.realestateproject.Persistence.Contrats.CustomerRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


@RequiredArgsConstructor
public class CustomerUpdateValidator implements ConstraintValidator<CustomerUpdateValidationRules, CustomerUpdateDto> {

    @Autowired
   private  CustomerRepository customerRepository;
    @Override
    public boolean isValid(CustomerUpdateDto customerUpdateDto, ConstraintValidatorContext constraintValidatorContext) {
        var data= customerRepository.countCustomerByEmail(customerUpdateDto.getEmail());
        return data <= 1;
    }
}
