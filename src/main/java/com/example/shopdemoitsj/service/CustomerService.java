package com.example.shopdemoitsj.service;

import com.example.shopdemoitsj.dto.CustomerDTO;
import com.example.shopdemoitsj.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> findAll();

    CustomerDTO findById(int custonmerId) throws CustomerNotFoundException;

    void save(CustomerDTO customerDTO);
}
