package com.example.shopdemoitsj.mapper;

import com.example.shopdemoitsj.dto.CustomerDto;
import com.example.shopdemoitsj.model.Customer;

/**
 * mapper.
 * */
public class CustomerMapper {
  private static CustomerMapper instance;

  /**
   * instance.
   * */
  public static CustomerMapper getInstance() {
    if (instance == null) {
      instance = new CustomerMapper();
    }
    return instance;
  }

  /**
   * chuyen doi qua dto.
   * */
  public CustomerDto toDto(Customer customer) {
    CustomerDto customerDto = new CustomerDto();
    customerDto.setId(customer.getId());
    customerDto.setUsername(customer.getUsername());
    customerDto.setPassword(customer.getPassword());
    customerDto.setType(customer.getType());

    return customerDto;
  }

  /**
   * chuyen doi qua entity.
   * */
  public Customer toEntity(CustomerDto customerDto) {
    Customer customer = new Customer();
    customer.setId(customerDto.getId());
    customer.setUsername(customerDto.getUsername());
    customer.setPassword(customerDto.getPassword());
    customer.setType(customerDto.getType());

    return customer;
  }
}
