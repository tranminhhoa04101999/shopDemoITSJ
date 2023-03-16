package com.example.shopdemoitsj.controller;

import com.example.shopdemoitsj.dto.AddToCartDto;
import com.example.shopdemoitsj.dto.CartDto;
import com.example.shopdemoitsj.service.impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** giỏ hành controller. */
@RestController
@RequestMapping("/api")
public class CartController {
  @Autowired private CartServiceImpl cartServiceImpl;

  @GetMapping("/carts/{customerId}")
  public CartDto findById(@PathVariable int customerId) {
    return cartServiceImpl.findByCustomerId(customerId);
  }

  @PostMapping("/carts")
  public ResponseEntity<HttpStatus> addToCart(@RequestBody AddToCartDto addToCartDto) {

    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
