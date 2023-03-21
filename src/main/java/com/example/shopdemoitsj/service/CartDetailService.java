package com.example.shopdemoitsj.service;

import com.example.shopdemoitsj.dto.AddToCartDto;
import com.example.shopdemoitsj.dto.CartDetailDto;
import com.example.shopdemoitsj.exception.QuantityLessThanOneException;

/**
 * cartdetail service .
 * */
public interface CartDetailService {
  CartDetailDto add(AddToCartDto addToCartDto);

  CartDetailDto update(CartDetailDto cartDetailDto) throws QuantityLessThanOneException;
}
