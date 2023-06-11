package com.qubitfaruk.realestateproject.Controller.Api.Customer;


import com.qubitfaruk.realestateproject.Business.Contrats.CustomerService;
import com.qubitfaruk.realestateproject.Core.Exception.BusinessException;
import com.qubitfaruk.realestateproject.Dto.RequestDtos.Customer.CustomerAddDto;
import com.qubitfaruk.realestateproject.Entity.enums.CustomerType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerApi {
    private final CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CustomerAddDto customerAddDto){
        var data= this.customerService.addCustomer(customerAddDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int id) throws BusinessException {
        var data=this.customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        var data=this.customerService.getAllCustomers();
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
    @GetMapping("/getbyid")
    public ResponseEntity<?> getById(@RequestParam int id) throws BusinessException {
        var data = this.customerService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
    @GetMapping("/getByCustomerType")
    public ResponseEntity<?> update(@RequestParam CustomerType customerType) throws BusinessException {
        var data= this.customerService.getByCustomerType(customerType);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
}
