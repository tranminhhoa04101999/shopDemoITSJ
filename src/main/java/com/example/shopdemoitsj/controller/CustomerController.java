package com.example.shopdemoitsj.controller;

import com.example.shopdemoitsj.dto.CustomerDTO;
import com.example.shopdemoitsj.exception.CustomerNotFoundException;
import com.example.shopdemoitsj.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> findAll(){
        return new ResponseEntity<>( customerServiceImpl.findAll(), HttpStatus.OK);
    }
    @GetMapping("/customers/{customerId}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable int customerId) throws CustomerNotFoundException {
        return new ResponseEntity<>(customerServiceImpl.findById(customerId),HttpStatus.OK);
    }
    @PostMapping("/customers")
    public ResponseEntity save(@RequestBody CustomerDTO customerDTO){
        customerServiceImpl.save(customerDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
















