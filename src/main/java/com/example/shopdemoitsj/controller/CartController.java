package com.example.shopdemoitsj.controller;

import com.example.shopdemoitsj.dto.AddToCartDto;
import com.example.shopdemoitsj.dto.CartDetailDto;
import com.example.shopdemoitsj.dto.CartDto;
import com.example.shopdemoitsj.exception.CartDetailNotFoundException;
import com.example.shopdemoitsj.exception.QuantityLessThanOneException;
import com.example.shopdemoitsj.repository.CartDetailRepository;
import com.example.shopdemoitsj.service.impl.CartDetailServiceImpl;
import com.example.shopdemoitsj.service.impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** giỏ hành controller. */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class CartController {
  @Autowired private CartServiceImpl cartServiceImpl;

  @Autowired private CartDetailServiceImpl cartDetailService;

  @Autowired private CartDetailRepository cartDetailRepository;

  @GetMapping("/carts/{customerId}")
  public CartDto findById(@PathVariable int customerId) throws CartDetailNotFoundException {
    return cartServiceImpl.findByCustomerId(customerId);
  }

  @PostMapping("/carts")
  public ResponseEntity<CartDetailDto> addToCart(@RequestBody AddToCartDto addToCartDto) {
    CartDetailDto dto = cartDetailService.add(addToCartDto);
    return new ResponseEntity<>(dto, HttpStatus.OK);
  }

  @PutMapping("/carts")
  public ResponseEntity<CartDetailDto> updateCartDetail(@RequestBody CartDetailDto cartDetailDto)
      throws QuantityLessThanOneException {
    CartDetailDto dto = cartDetailService.update(cartDetailDto);
    return new ResponseEntity<>(dto, HttpStatus.OK);
  }

  @DeleteMapping("/carts/{cartDetailId}")
  public ResponseEntity<HttpStatus> deleteCartDetail(@PathVariable int cartDetailId) {
    cartDetailRepository.deleteById(cartDetailId);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
