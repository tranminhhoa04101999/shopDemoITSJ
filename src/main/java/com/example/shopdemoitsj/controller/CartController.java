package com.example.shopdemoitsj.controller;

import com.example.shopdemoitsj.dto.AddToCartDTO;
import com.example.shopdemoitsj.dto.CartDTO;
import com.example.shopdemoitsj.model.Cart;
import com.example.shopdemoitsj.service.impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CartController {
    @Autowired
    private CartServiceImpl cartServiceImpl;

    @GetMapping("/carts/{customerId}")
    public CartDTO findById(@PathVariable int customerId){
        return cartServiceImpl.findByCustomerId(customerId);
    }
    @PostMapping("/carts")
    public ResponseEntity addToCart(@RequestBody AddToCartDTO addToCartDTO){

        return new ResponseEntity(HttpStatus.CREATED);
    }

}
