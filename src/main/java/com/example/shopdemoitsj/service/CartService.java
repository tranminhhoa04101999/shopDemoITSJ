package com.example.shopdemoitsj.service;

import com.example.shopdemoitsj.dto.CartDto;

/**
 * cart service interface.
 * */
public interface CartService {
  CartDto findByCustomerId(int customerId);
}
