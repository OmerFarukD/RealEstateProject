package com.qubitfaruk.realestateproject.Controller.Api;


import com.qubitfaruk.realestateproject.Business.Contrats.CustomerService;
import com.qubitfaruk.realestateproject.Core.Exception.BusinessException;
import com.qubitfaruk.realestateproject.Core.Results.DataResult;
import com.qubitfaruk.realestateproject.Core.Results.Result;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.Customer.CustomerAddDto;
import com.qubitfaruk.realestateproject.Dto.ResponseDtos.Customer.CustomerResponseDto;
import com.qubitfaruk.realestateproject.Entity.enums.CustomerType;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerApi {
    private final CustomerService customerService;

    public CustomerApi(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody CustomerAddDto customerAddDto) throws BusinessException {
        var data= this.customerService.addCustomer(customerAddDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @PostMapping("/delete")
    public ResponseEntity<Result> delete(@RequestParam Integer id) throws BusinessException {
        var data=this.customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<CustomerResponseDto>>> getAll(){
        var data=this.customerService.getAllCustomers();
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
    @GetMapping("/getbyid")
    public ResponseEntity<DataResult<CustomerResponseDto>> getById(@RequestParam int id) throws BusinessException {
        var data = this.customerService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
    @GetMapping("/getByCustomerType")
    public ResponseEntity<Result> update(@RequestParam CustomerType customerType) throws BusinessException {
        var data= this.customerService.getByCustomerType(customerType);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
}
