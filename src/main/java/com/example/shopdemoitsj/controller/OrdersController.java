package com.example.shopdemoitsj.controller;

import com.example.shopdemoitsj.dto.CartDto;
import com.example.shopdemoitsj.dto.OrdersDto;
import com.example.shopdemoitsj.exception.EmptyCartException;
import com.example.shopdemoitsj.exception.OrderFalse;
import com.example.shopdemoitsj.service.impl.OrdersServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * test controller order.
 * */
@RestController
@RequestMapping("/api")
public class OrdersController {
  @Autowired OrdersServiceImpl ordersService;

  @PostMapping("/orders")
  public ResponseEntity<HttpStatus> placeAnOrder(@RequestBody CartDto cartDto)
      throws OrderFalse, EmptyCartException {
    ordersService.placeAnOrder(cartDto);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/orders/{customerId}")
  public ResponseEntity<List<OrdersDto>> findByCustomerId(@PathVariable int customerId) {
    List<OrdersDto> ordersDtoList = ordersService.findByCustomerId(customerId);
    return new ResponseEntity<>(ordersDtoList, HttpStatus.OK);
  }

  @GetMapping("orders/lastestOrder/{customerId}")
  public ResponseEntity<OrdersDto> findByCustomerIdAndMaxOrderId(@PathVariable int customerId) {
    return new ResponseEntity<>(
        ordersService.findByCustomerIdAndMaxOrderId(customerId), HttpStatus.OK);
  }
}
