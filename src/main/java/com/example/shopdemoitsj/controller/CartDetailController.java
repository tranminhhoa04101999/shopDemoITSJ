package com.example.shopdemoitsj.controller;

import com.example.shopdemoitsj.service.CartDetailService;
import com.example.shopdemoitsj.service.impl.CartDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CartDetailController {

    @Autowired
    private CartDetailServiceImpl cartDetailServiceImpl;



}
