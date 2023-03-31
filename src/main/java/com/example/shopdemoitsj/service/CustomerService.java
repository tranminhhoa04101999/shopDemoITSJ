package com.example.shopdemoitsj.service;

import com.example.shopdemoitsj.dto.CustomerDto;
import com.example.shopdemoitsj.exception.CustomerNotFoundException;
import com.example.shopdemoitsj.exception.UsernameExistException;
import java.util.List;

/**
 * customer service interface.
 * */
public interface CustomerService {
  List<CustomerDto> findAll();

  CustomerDto findById(int custonmerId) throws CustomerNotFoundException;

  CustomerDto save(CustomerDto customerDto) throws UsernameExistException;

  CustomerDto findByUserName(String userName);


}
