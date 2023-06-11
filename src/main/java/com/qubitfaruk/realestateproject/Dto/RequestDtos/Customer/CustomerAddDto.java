package com.qubitfaruk.realestateproject.Dto.RequestDtos.Customer;

import com.qubitfaruk.realestateproject.AOP.Attributes.Validation.CustomerAddValidationRules;
import com.qubitfaruk.realestateproject.Entity.enums.CustomerType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@CustomerAddValidationRules
public class CustomerAddDto{
    @NotNull
   private int workplaceId;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
   private String surname;

    @NotBlank
    @NotNull
    private String phoneNumber;
    @Email
    @NotBlank
    @NotNull
    private String email;

    @NotNull
    private CustomerType customerType;

    public int getWorkplaceId() {
        return workplaceId;
    }

    public void setWorkplaceId(int workplaceId) {
        this.workplaceId = workplaceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
