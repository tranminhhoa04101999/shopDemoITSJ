package com.example.shopdemoitsj.controller;

import com.example.shopdemoitsj.dto.CustomerDto;
import com.example.shopdemoitsj.exception.CustomerNotFoundException;
import com.example.shopdemoitsj.service.impl.CustomerServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  người mua hàng controller.
 * */
@RestController
@RequestMapping("/api")
public class CustomerController {
  @Autowired private CustomerServiceImpl customerServiceImpl;

  @GetMapping("/customers")
  public ResponseEntity<List<CustomerDto>> findAll() {
    return new ResponseEntity<>(customerServiceImpl.findAll(), HttpStatus.OK);
  }

  @GetMapping("/customers/{customerId}")
  public ResponseEntity<CustomerDto> findById(@PathVariable int customerId)
      throws CustomerNotFoundException {
    return new ResponseEntity<>(customerServiceImpl.findById(customerId), HttpStatus.OK);
  }

  @PostMapping("/customers")
  public ResponseEntity<HttpStatus> save(@RequestBody CustomerDto customerDto) {
    customerServiceImpl.save(customerDto);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
