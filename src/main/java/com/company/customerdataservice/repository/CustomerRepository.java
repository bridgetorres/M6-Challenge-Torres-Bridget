package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Integer> {

    //Customer save(Customer customer);

    Optional<Customer> findById(Integer integer);
   // Customer updateCustomer(Customer customer);
    List<Customer> findByState(String state);

}
