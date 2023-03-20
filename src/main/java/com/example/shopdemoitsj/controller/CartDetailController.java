package com.example.shopdemoitsj.controller;

import com.example.shopdemoitsj.service.impl.CartDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  chi tiết giỏ hành controller.
 * */
@RestController
@RequestMapping("/api")
public class CartDetailController {

  @Autowired private CartDetailServiceImpl cartDetailServiceImpl;


}
