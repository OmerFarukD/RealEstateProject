package com.qubitfaruk.realestateproject.Business.Profiles;

import com.qubitfaruk.realestateproject.Dto.RequestDtos.Customer.CustomerAddDto;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.Customer.CustomerUpdateDto;
import com.qubitfaruk.realestateproject.Dto.ResponseDtos.Customer.CustomerResponseDto;
import com.qubitfaruk.realestateproject.Entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {

CustomerMapper INSTANCE= Mappers.getMapper(CustomerMapper.class);
CustomerResponseDto customerToCustomerResponseDto(Customer customer);
Customer responseDtoTocustomer(CustomerResponseDto customerResponseDto);
List<CustomerResponseDto> customersToCustomerResponsesDto(List<Customer> customers);
Customer customerAddDtoToCustomer(CustomerAddDto customerAddDto);
Customer customerUpdateDtoToCustomer(CustomerUpdateDto customerUpdateDto);
}
