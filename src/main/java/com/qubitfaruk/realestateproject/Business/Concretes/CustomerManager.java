package com.qubitfaruk.realestateproject.Business.Concretes;

import com.qubitfaruk.realestateproject.AOP.Attributes.Logging.LogDb.LoggerToDb;
import com.qubitfaruk.realestateproject.Business.Constants.Messages;
import com.qubitfaruk.realestateproject.Business.Contrats.CustomerService;
import com.qubitfaruk.realestateproject.Business.Contrats.WorkPlaceService;
import com.qubitfaruk.realestateproject.Business.Profiles.CustomerMapper;
import com.qubitfaruk.realestateproject.Business.Profiles.WorkPlaceMapper;
import com.qubitfaruk.realestateproject.Core.Exception.BusinessException;
import com.qubitfaruk.realestateproject.Core.Results.DataResult;
import com.qubitfaruk.realestateproject.Core.Results.Result;
import com.qubitfaruk.realestateproject.Core.Results.SuccessDataResult;
import com.qubitfaruk.realestateproject.Core.Results.SuccessResult;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.Customer.CustomerAddDto;
import com.qubitfaruk.realestateproject.Dto.ResponseDtos.Customer.CustomerResponseDto;
import com.qubitfaruk.realestateproject.Entity.Customer;
import com.qubitfaruk.realestateproject.Entity.enums.CustomerType;
import com.qubitfaruk.realestateproject.Persistence.Contrats.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;
    private final WorkPlaceService workPlaceService;

    public CustomerManager(CustomerRepository customerRepository, WorkPlaceService workPlaceService) {
        this.customerRepository = customerRepository;
        this.workPlaceService = workPlaceService;
    }



    @Override
    @LoggerToDb
    public Result addCustomer(CustomerAddDto customerAddDto) throws BusinessException {
        Customer data = setCustomerAndWorkplace(customerAddDto);
        this.customerRepository.save(data);
        return new SuccessResult(Messages.addCustomerMessage(data.getEmail()));
    }



    @Override
    @LoggerToDb
    public Result deleteCustomer(int id) throws BusinessException {
        var data= this.customerRepository.findById(id).orElseThrow(()-> new BusinessException(Messages.customerNotFoundMessage(id)));
        this.customerRepository.delete(data);
        return new SuccessResult(Messages.customerDeletedMessage(id));
    }

    @Override
    public DataResult<List<CustomerResponseDto>> getAllCustomers() {
        var customers= this.customerRepository.findAll();
        var dtoList=CustomerMapper.INSTANCE.customersToCustomerResponsesDto(customers);
        return new SuccessDataResult<>(dtoList,Messages.customerListMessage);
    }

    @Override
    public DataResult<CustomerResponseDto> getById(int id) throws BusinessException {
        var customer= this.customerRepository.findById(id).orElseThrow(()->new BusinessException(Messages.customerNotFoundMessage(id)));
        var data=CustomerMapper.INSTANCE.customerToCustomerResponseDto(customer);
        return new SuccessDataResult<>(data,Messages.getCustomerMessage(id));
    }
    @Override
    public DataResult<List<CustomerResponseDto>> getByCustomerType(CustomerType customerType) throws BusinessException {
        var customers= this.customerRepository.findByCustomerType(customerType);
        var data=CustomerMapper.INSTANCE.customersToCustomerResponsesDto(customers);
        return new SuccessDataResult<>(data,Messages.customerListMessage);
    }

//Business Rules
    private Customer setCustomerAndWorkplace(CustomerAddDto customerAddDto) throws BusinessException {
        var data=CustomerMapper.INSTANCE.customerAddDtoToCustomer(customerAddDto);
        var workplaceResponse=workPlaceService.getById(customerAddDto.getWorkplaceId());
        if (workplaceResponse.isSuccess()){
            var workplace= WorkPlaceMapper.INSTANCE.ResponseDtoToWorkPlace(workplaceResponse.getData());
            data.setWorkPlace(workplace);
        }
        return data;
    }
}
