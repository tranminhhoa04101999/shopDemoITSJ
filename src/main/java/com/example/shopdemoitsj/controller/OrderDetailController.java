package com.example.shopdemoitsj.controller;

import com.example.shopdemoitsj.service.impl.OrderDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderDetailController {
@Autowired
  OrderDetailServiceImpl orderDetailService;
}
