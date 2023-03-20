package com.example.shopdemoitsj.service.impl;

import com.example.shopdemoitsj.dto.CustomerDto;
import com.example.shopdemoitsj.exception.CustomerNotFoundException;
import com.example.shopdemoitsj.mapper.CustomerMapper;
import com.example.shopdemoitsj.model.Customer;
import com.example.shopdemoitsj.repository.CustomerRepository;
import com.example.shopdemoitsj.service.CustomerService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * customer impl customer interface.
 * */
@Service
public class CustomerServiceImpl implements CustomerService {
  @Autowired private CustomerRepository customerRepository;

  @Override
  public List<CustomerDto> findAll() {
    return customerRepository.findAll().stream()
        .map(customer -> CustomerMapper.getInstance().toDto(customer))
        .collect(Collectors.toList());
  }

  @Override
  public CustomerDto findById(int customerId) throws CustomerNotFoundException {
    Customer customer;
    Optional<Customer> customerOptional = customerRepository.findById(customerId);
    customer = customerOptional.orElseGet(Customer::new);

    if (customerOptional.isPresent()) {
      return CustomerMapper.getInstance().toDto(customer);
    } else {
      throw new CustomerNotFoundException();
    }
  }

  @Override
  public CustomerDto save(CustomerDto customerDto) {
    customerRepository.save(CustomerMapper.getInstance().toEntity(customerDto));
    return customerDto;
  }
}
