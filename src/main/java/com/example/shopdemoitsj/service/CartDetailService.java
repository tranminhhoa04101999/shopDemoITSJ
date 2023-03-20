package com.example.shopdemoitsj.service;

import com.example.shopdemoitsj.dto.AddToCartDto;
import com.example.shopdemoitsj.dto.CartDetailDto;

/**
 * cartdetail service .
 * */
public interface CartDetailService {
  CartDetailDto add(AddToCartDto addToCartDto);

  CartDetailDto update(CartDetailDto cartDetailDto);
}
