package com.example.shopdemoitsj.mapper;

import com.example.shopdemoitsj.dto.CustomerDTO;
import com.example.shopdemoitsj.model.Customer;

public class CustomerMapper {
    private static CustomerMapper INSTANCE;

    public static CustomerMapper getInstance(){
        if(INSTANCE == null){
            INSTANCE = new CustomerMapper();
        }
        return INSTANCE;
    }

    public CustomerDTO toDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setUsername(customer.getUsername());
        customerDTO.setPassword(customer.getPassword());
        customerDTO.setType(customer.getType());

        return customerDTO;
    }
    public Customer toEntity(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setUsername(customerDTO.getUsername());
        customer.setPassword(customerDTO.getPassword());
        customer.setType(customerDTO.getType());

        return customer;
    }
}



















