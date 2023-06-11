package com.qubitfaruk.realestateproject.Persistence.Contrats;

import com.qubitfaruk.realestateproject.Entity.Customer;
import com.qubitfaruk.realestateproject.Entity.enums.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
    List<Customer> findByCustomerType(CustomerType customerType);
    int countCustomerByEmail(String email);
}
