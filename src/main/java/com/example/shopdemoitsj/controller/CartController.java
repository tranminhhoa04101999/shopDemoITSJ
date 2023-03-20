package com.example.shopdemoitsj.controller;

import com.example.shopdemoitsj.dto.AddToCartDto;
import com.example.shopdemoitsj.dto.CartDetailDto;
import com.example.shopdemoitsj.dto.CartDto;
import com.example.shopdemoitsj.model.CartDetail;
import com.example.shopdemoitsj.service.impl.CartDetailServiceImpl;
import com.example.shopdemoitsj.service.impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** giỏ hành controller. */
@RestController
@RequestMapping("/api")
public class CartController {
  @Autowired private CartServiceImpl cartServiceImpl;

  @Autowired private CartDetailServiceImpl cartDetailService;

  @GetMapping("/carts/{customerId}")
  public CartDto findById(@PathVariable int customerId) {
    return cartServiceImpl.findByCustomerId(customerId);
  }

  @PostMapping("/carts")
  public ResponseEntity<CartDetailDto> addToCart(@RequestBody AddToCartDto addToCartDto) {
    CartDetailDto dto = cartDetailService.add(addToCartDto);
    return new ResponseEntity<>(dto,HttpStatus.OK);
  }

  @PutMapping("/carts")
  public ResponseEntity<HttpStatus> updateCartDetail(@RequestBody CartDetailDto cartDetailDto) {
    cartDetailService.update(cartDetailDto);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
