package com.qubitfaruk.realestateproject.Business.Contrats;
import com.qubitfaruk.realestateproject.Core.Exception.BusinessException;
import com.qubitfaruk.realestateproject.Core.Results.DataResult;
import com.qubitfaruk.realestateproject.Core.Results.Result;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.Customer.CustomerAddDto;
import com.qubitfaruk.realestateproject.Dto.ResponseDtos.Customer.CustomerResponseDto;
import com.qubitfaruk.realestateproject.Entity.enums.CustomerType;
import java.util.List;

public interface CustomerService {
    Result addCustomer(CustomerAddDto customerAddDto) throws BusinessException;
    Result deleteCustomer(int id) throws BusinessException;
    DataResult<List<CustomerResponseDto>> getAllCustomers();
    DataResult<CustomerResponseDto> getById(int id) throws BusinessException;
    DataResult<List<CustomerResponseDto>> getByCustomerType(CustomerType customerType) throws BusinessException;

}
