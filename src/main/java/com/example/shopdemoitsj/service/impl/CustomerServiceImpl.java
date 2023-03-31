package com.example.shopdemoitsj.service.impl;

import com.example.shopdemoitsj.dto.CustomerDto;
import com.example.shopdemoitsj.exception.CustomerNotFoundException;
import com.example.shopdemoitsj.exception.UsernameExistException;
import com.example.shopdemoitsj.mapper.CustomerMapper;
import com.example.shopdemoitsj.model.Cart;
import com.example.shopdemoitsj.model.Customer;
import com.example.shopdemoitsj.repository.CartRepository;
import com.example.shopdemoitsj.repository.CustomerRepository;
import com.example.shopdemoitsj.service.CustomerService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/** customer impl customer interface. */
@Service
public class CustomerServiceImpl implements CustomerService {
  @Autowired private CustomerRepository customerRepository;

  @Autowired CartRepository cartRepository;

  @Override
  public CustomerDto findByUserName(String userName) {
    Customer customer = customerRepository.findByUsername(userName);
    return CustomerMapper.getInstance().toDto(customer);
  }

  @Override
  public List<CustomerDto> findAll() {
    return customerRepository.findAll().stream()
        .map(customer -> CustomerMapper.getInstance().toDto(customer))
        .collect(Collectors.toList());
  }

  @Autowired PasswordEncoder passwordEncoder;

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
  public CustomerDto save(CustomerDto customerDto) throws UsernameExistException {
    // kiểm tra username tồn tại chưa
    Customer customer1 = customerRepository.findByUsername(customerDto.getUsername());
    System.out.println(customer1);
    if (customer1 != null) {
      throw new UsernameExistException();
    }

    // tạo customer
    Customer customer = CustomerMapper.getInstance().toEntity(customerDto);
    customer.setPassword(passwordEncoder.encode(customer.getPassword()));
    Customer customerSave = customerRepository.save(customer);
    // khi tạo thành công tạo luôn giỏ hàng trống cho họ.
    if (customerSave.getId() > 0) {
      Cart cart = new Cart(0, customerSave);
      cartRepository.save(cart);
    }

    return CustomerMapper.getInstance().toDto(customerSave);
  }
}
