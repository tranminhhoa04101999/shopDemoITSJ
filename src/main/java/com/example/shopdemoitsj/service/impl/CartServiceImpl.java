package com.example.shopdemoitsj.service.impl;

import com.example.shopdemoitsj.dto.CartDetailDto;
import com.example.shopdemoitsj.dto.CartDto;
import com.example.shopdemoitsj.mapper.CartDetailMapper;
import com.example.shopdemoitsj.mapper.CustomerMapper;
import com.example.shopdemoitsj.model.Cart;
import com.example.shopdemoitsj.model.Customer;
import com.example.shopdemoitsj.repository.CartDetailRepository;
import com.example.shopdemoitsj.repository.CartRepository;
import com.example.shopdemoitsj.repository.CustomerRepository;
import com.example.shopdemoitsj.service.CartService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * class implement service interface.
 * */
@Service
public class CartServiceImpl implements CartService {
  @Autowired private CartRepository cartRepository;
  @Autowired private CustomerRepository customerRepository;
  @Autowired private CartDetailRepository cartDetailRepository;

  @Override
  public CartDto findByCustomerId(int customerId) {
    CartDto cartDto = new CartDto();
    Cart cart = cartRepository.findByCustomerId(customerId);
    cartDto.setId(cart.getId());

    Customer customer;
    Optional<Customer> customerOpt = customerRepository.findById(customerId);
    customer = customerOpt.orElseGet(Customer::new);

    cartDto.setCustomerDto(CustomerMapper.getInstance().toDto(customer));

    List<CartDetailDto> list =
        cartDetailRepository.findByCartId(cart.getId()).stream()
            .map(temp -> CartDetailMapper.getInstance().toDto(temp))
            .collect(Collectors.toList());
    cartDto.setCartDetailDtos(list);
    return cartDto;
  }
}
