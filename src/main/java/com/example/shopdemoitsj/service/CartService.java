package com.example.shopdemoitsj.service;


import com.example.shopdemoitsj.dto.AddToCartDTO;
import com.example.shopdemoitsj.dto.CartDTO;

public interface CartService {
    CartDTO findByCustomerId(int customerId);

}
