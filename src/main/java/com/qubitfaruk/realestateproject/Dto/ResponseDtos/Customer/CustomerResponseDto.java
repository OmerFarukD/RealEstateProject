package com.qubitfaruk.realestateproject.Dto.ResponseDtos.Customer;
import com.qubitfaruk.realestateproject.Entity.enums.CustomerType;
public record CustomerResponseDto(int customerId,
                                  String name,
                                  String surname,
                                  String phoneNumber,
                                  String email,
                                  CustomerType customerType) {}
