package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


@RunWith(SpringRunner.class)
@SpringBootTest

public class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepo;

    @Before
    public void setUp() throws Exception {
        customerRepo.deleteAll();
    }

    @Test
    public void addCustomer() {

        Customer customer = new Customer();
        customer.setFirstName("Gwen");
        customer.setLastName("Stacy");
        customer.setEmail("GwenStacy@gmail.com");
        customer.setCompany("Netflix");
        customer.setPhone("290-745-6790");
        customer.setAddress_one("Null");
        customer.setAddress_two("Null");
        customer.setCity("HollyWood");
        customer.setState("Califorinia");
        customer.setPostalCode(7688);
        customer.setCountry("United States");

        customer = customerRepo.save(customer);

        Optional<Customer> customer1 = customerRepo.findById(customer.getId());

        assertEquals(customer1.get(), customer);

    }
    @Test
    public void shouldGetCostumersByState() throws Exception {


        Customer customer = new Customer();
        customer.setFirstName("Gwen");
        customer.setLastName("Stacy");
        customer.setEmail("GwenStacy@gmail.com");
        customer.setCompany("Netflix");
        customer.setPhone("290-745-6790");
        customer.setAddress_one("Null");
        customer.setAddress_two("Null");
        customer.setCity("HollyWood");
        customer.setState("Califorinia");
        customer.setPostalCode(7688);
        customer.setCountry("United States");


        customerRepo.save(customer);

        List<Customer> customerList = customerRepo.findByState(customer.getState());


      //  assertEquals(customer, customer.getClass());
        assertEquals(2, customerList.size());
    }

    @Test
    public void shouldGetAConsoleById() throws Exception {

        Customer customer = new Customer();
        customer.setFirstName("Gwen");
        customer.setLastName("Stacy");
        customer.setEmail("GwenStacy@gmail.com");
        customer.setCompany("Netflix");
        customer.setPhone("290-745-6790");
        customer.setAddress_one("Null");
        customer.setAddress_two("Null");
        customer.setCity("HollyWood");
        customer.setState("Califorinia");
        customer.setPostalCode(7688);
        customer.setCountry("United States");

        customerRepo.save(customer);

        Optional<Customer> customer1 = customerRepo.findById(customer.getId());


        assertEquals(customer, customer1.get());

    }

    @Test
    public void updateCustomer() {

        Customer customer = new Customer();
        customer.setFirstName("Gwen");
        customer.setLastName("Stacy");
        customer.setEmail("GwenStacy@gmail.com");
        customer.setCompany("Netflix");
        customer.setPhone("290-745-6790");
        customer.setAddress_one("Null");
        customer.setAddress_two("Null");
        customer.setCity("HollyWood");
        customer.setState("Califorinia");
        customer.setPostalCode(7688);
        customer.setCountry("United States");

        customerRepo.save(customer);

        customer.setFirstName("UPDATED");

        customerRepo.save(customer);

        Optional<Customer> customer1 = customerRepo.findById(customer.getId());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void deleteCustomer() {

        Customer customer = new Customer();
        customer.setFirstName("Gwen");
        customer.setLastName("Stacy");
        customer.setEmail("GwenStacy@gmail.com");
        customer.setCompany("Netflix");
        customer.setPhone("290-745-6790");
        customer.setAddress_one("Null");
        customer.setAddress_two("Null");
        customer.setCity("HollyWood");
        customer.setState("Califorinia");
        customer.setPostalCode(7688);
        customer.setCountry("United States");

        customerRepo.save(customer);


        customerRepo.deleteById(customer.getId());


        Optional<Customer> customer1 = customerRepo.findById(customer.getId());
        assertFalse(customer1.isPresent());
    }
    }


