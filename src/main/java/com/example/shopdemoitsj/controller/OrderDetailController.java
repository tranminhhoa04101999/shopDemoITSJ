package com.example.shopdemoitsj.controller;

import com.example.shopdemoitsj.dto.OrderDetailDto;
import com.example.shopdemoitsj.service.impl.OrderDetailServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * order detail controller.
 * */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class OrderDetailController {
  @Autowired OrderDetailServiceImpl orderDetailService;

  /**
   * lấy orderdetail theo order id.
   * */
  @GetMapping("/orderDetails/{orderId}")
  public ResponseEntity<List<OrderDetailDto>> findByOrderId(@PathVariable int orderId) {
    List<OrderDetailDto> orderDetailDtoList = orderDetailService.findByOrderId(orderId);

    return new ResponseEntity<>(orderDetailDtoList, HttpStatus.OK);
  }
}
