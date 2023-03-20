package com.example.shopdemoitsj.controller;

import com.example.shopdemoitsj.dto.OrdersDto;
import com.example.shopdemoitsj.service.impl.OrdersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrdersController {
  @Autowired
  OrdersServiceImpl ordersService;


  @GetMapping("/orders/{customerId}")
  public ResponseEntity<List<OrdersDto>> findByCustomerId(@PathVariable int customerId) {
    List<OrdersDto> ordersDtoList = ordersService.findByCustomerId(customerId);
    return new ResponseEntity<>(ordersDtoList,HttpStatus.OK);
  }

  @GetMapping("orders/lastestOrder/{customerId}")
  public ResponseEntity<OrdersDto> findByCustomerIdAndMaxOrderId(@PathVariable int customerId){
    return new ResponseEntity<>(ordersService.findByCustomerIdAndMaxOrderId(customerId),HttpStatus.OK);
  }
}
