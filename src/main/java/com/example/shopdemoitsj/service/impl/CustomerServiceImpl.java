package com.example.shopdemoitsj.service.impl;

import com.example.shopdemoitsj.dto.CustomerDTO;
import com.example.shopdemoitsj.exception.CustomerNotFoundException;
import com.example.shopdemoitsj.mapper.CustomerMapper;
import com.example.shopdemoitsj.repository.CustomerRepository;
import com.example.shopdemoitsj.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDTO> findAll(){
        return customerRepository.findAll().stream().map(customer -> CustomerMapper.getInstance().toDTO(customer)).collect(Collectors.toList());
    }
    @Override
    public CustomerDTO findById(int customerId) throws CustomerNotFoundException {
        if(customerRepository.findById(customerId).isPresent()){
            return CustomerMapper.getInstance().toDTO(customerRepository.findById(customerId).get());
        }
        else{
            throw new CustomerNotFoundException();
        }
    }
    @Override
    public void save(CustomerDTO customerDTO){
        customerRepository.save(CustomerMapper.getInstance().toEntity(customerDTO));
    }


}
