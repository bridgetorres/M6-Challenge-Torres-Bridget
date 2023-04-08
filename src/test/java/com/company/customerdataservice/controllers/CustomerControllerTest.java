package com.company.customerdataservice.controllers;
import com.company.customerdataservice.controller.CustomerController;
import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CustomerController.class)

public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;
  // private ServiceLayer serviceLayer;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void  shouldCreateNewCustomer() throws Exception{
        Customer customer = new Customer();
        customer.setFirstName("Jose");
        customer.setLastName("Flow");
        customer.setEmail("joseflow@gmail.com");
        customer.setCompany("Microsoft");
        customer.setPhone("220-445-6780");
        customer.setAddress_one("Null");
        customer.setAddress_two("Null");
        customer.setCity("Newark");
        customer.setState("New Jersey");
        customer.setPostalCode(3323);
        customer.setCountry("United States");

        String customerJson = mapper.writeValueAsString(customer);

        mockMvc.perform(
                        put("/customers")
                                .content(customerJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());

    }

    @Test
    public void shouldDeleteCustomer()throws Exception{
        mockMvc.perform(
                delete("/customers/1")
        )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    public void shouldGetCustomerById()throws Exception{
        mockMvc.perform(
                        get("/customers/1")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllCustomerByState () throws Exception {

        mockMvc.perform(
                        get("/customers/state/{state}")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void  shouldUpdateCustomer() throws Exception{
        Customer customer = new Customer();
        customer.setFirstName("Jose");
        customer.setLastName("Flow");
        customer.setEmail("joseflow@gmail.com");
        customer.setCompany("Microsoft");
        customer.setPhone("220-445-6780");
        customer.setAddress_one("Null");
        customer.setAddress_two("Null");
        customer.setCity("Miami");
        customer.setState("Florida");
        customer.setPostalCode(4567);
        customer.setCountry("United States");

        String customerJson = mapper.writeValueAsString(customer);


        mockMvc.perform(
                        put("/customers")
                                .content(customerJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

}
