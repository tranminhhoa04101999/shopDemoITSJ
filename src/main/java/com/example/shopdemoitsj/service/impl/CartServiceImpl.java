package com.example.shopdemoitsj.service.impl;

import com.example.shopdemoitsj.dto.CartDTO;
import com.example.shopdemoitsj.dto.CartDetailDTO;
import com.example.shopdemoitsj.mapper.CartDetailMapper;
import com.example.shopdemoitsj.mapper.CustomerMapper;
import com.example.shopdemoitsj.model.Cart;
import com.example.shopdemoitsj.model.Customer;
import com.example.shopdemoitsj.repository.CartDetailRepository;
import com.example.shopdemoitsj.repository.CartRepository;
import com.example.shopdemoitsj.repository.CustomerRepository;

import com.example.shopdemoitsj.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Override
    public CartDTO findByCustomerId(int customerId){
        CartDTO cartDTO = new CartDTO();
        Cart cart = cartRepository.findByCustomer_Id(customerId);
        cartDTO.setId(cart.getId());
        Customer customer = customerRepository.findById(customerId).get();
        cartDTO.setCustomerDTO(CustomerMapper.getInstance().toDTO(customer));

        List<CartDetailDTO> list = cartDetailRepository.findByCart_Id(cart.getId()).stream().map(temp->CartDetailMapper.getInstance().toDTO(temp)).collect(Collectors.toList());
        cartDTO.setCartDetailDTOS(list);
        return cartDTO;
    }

}
