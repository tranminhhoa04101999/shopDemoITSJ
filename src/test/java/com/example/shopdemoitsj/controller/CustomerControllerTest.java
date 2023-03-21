package com.example.shopdemoitsj.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.example.shopdemoitsj.dto.CustomerDto;
import com.example.shopdemoitsj.exception.CustomerNotFoundException;
import com.example.shopdemoitsj.mapper.CustomerMapper;
import com.example.shopdemoitsj.model.Customer;
import com.example.shopdemoitsj.service.impl.CustomerServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.ResponseEntity;

/**
 * test controller customer.
 * */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CustomerControllerTest {
  @Mock CustomerServiceImpl customerService;
  @InjectMocks CustomerController customerController;

  Customer customer;
  CustomerDto customerDto;

  @BeforeEach
  void init() {
    customer = new Customer(1, "hoa", "123", 1);
    customerDto = CustomerMapper.getInstance().toDto(customer);
  }

  @AfterEach
  void clean() {
    customer = null;
    customerDto = null;
  }

  @Test
  @DisplayName("Junit test get all customer")
  void findAll() {
    CustomerDto customerDto2 = new CustomerDto(2, "hoa2", "1234", 1);
    List<CustomerDto> customerDtosList = new ArrayList<>();
    customerDtosList.add(customerDto);
    customerDtosList.add(customerDto2);

    when(customerService.findAll()).thenReturn(customerDtosList);

    ResponseEntity<List<CustomerDto>> result = customerController.findAll();

    assertThat(result.getBody()).hasSameSizeAs(customerDtosList);
    assertThat(result.getBody().get(0).getUsername())
        .isEqualTo(customerDtosList.get(0).getUsername());
    assertThat(result.getBody().get(1).getUsername())
        .isEqualTo(customerDtosList.get(1).getUsername());
  }

  @Test
  @DisplayName("Junit test find by id  ")
  void findById() throws CustomerNotFoundException {
    when(customerService.findById(customer.getId())).thenReturn(customerDto);

    ResponseEntity<CustomerDto> result = customerController.findById(customer.getId());

    assertThat(result.getBody()).isNotNull();
    assertThat(result.getBody().getUsername()).isEqualTo(customerDto.getUsername());
  }
}
