package com.example.shopdemoitsj.service;

import com.example.shopdemoitsj.dto.CartDto;
import com.example.shopdemoitsj.exception.CartDetailNotFoundException;

/**
 * cart service interface.
 * */
public interface CartService {
  CartDto findByCustomerId(int customerId) throws CartDetailNotFoundException;
}
