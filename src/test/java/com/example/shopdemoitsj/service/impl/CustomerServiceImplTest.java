package com.example.shopdemoitsj.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.shopdemoitsj.dto.CustomerDto;
import com.example.shopdemoitsj.exception.CustomerNotFoundException;
import com.example.shopdemoitsj.mapper.CustomerMapper;
import com.example.shopdemoitsj.model.Customer;
import com.example.shopdemoitsj.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CustomerServiceImplTest {

  @Mock CustomerRepository customerRepository;
  @InjectMocks CustomerServiceImpl customerService;

  CustomerDto customerDto;
  Customer customer;

  @BeforeEach
  void init() {
    customer = new Customer(1, "hoa", "123456", 0);
    customerDto = CustomerMapper.getInstance().toDto(customer);
  }

  @AfterEach
  void clean() {
    customer = null;
    customerDto = null;
  }

  @Test
  void whenFindAll_thenReturnList() {
    // precondition
    List<Customer> mockData = new ArrayList<>();

    for (int i = 0; i < 3; i++) {
      mockData.add(new Customer(i, "hoa", "123456", 0));
    }
    // transfer dto
    List<CustomerDto> mockDataDto =
        mockData.stream()
            .map(temp -> CustomerMapper.getInstance().toDto(temp))
            .collect(Collectors.toList());
    // when
    when(customerRepository.findAll()).thenReturn(mockData);
    List<CustomerDto> result = customerService.findAll();
    // then
    assertThat(result).hasSameSizeAs(mockData).hasSameElementsAs(mockDataDto);

    verify(customerRepository).findAll();
  }

  @Test
  void whenFindById_thenThrowException() {
    // precondition
    int invalidItemId = 7000;
    when(customerRepository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(null));
    // when

    // then
    assertThatThrownBy(() -> customerService.findById(invalidItemId))
        .isInstanceOf(CustomerNotFoundException.class);
    verify(customerRepository).findById(any(Integer.class));
  }

  @Test
  void whenSave_thenReturnSaveCustomer() {
    // precondition
    when(customerRepository.save(customer)).thenReturn(customer);
    //    // when
    CustomerDto result = customerService.save(customerDto);
    //    // then
    assertThat(result).isNotNull().isEqualTo(customerDto);

    verify(customerRepository).save(customer);
  }
}
