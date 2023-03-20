package com.example.shopdemoitsj.service;


import com.example.shopdemoitsj.dto.OrdersDto;
import com.example.shopdemoitsj.exception.OrdersNotFoundException;

import java.util.List;

/**
 * service.
 * */
public interface OrdersService {
  OrdersDto saveOrder(OrdersDto ordersDto);

  OrdersDto findById(int id) throws OrdersNotFoundException;

  void delete(int id);

  List<OrdersDto> findByCustomerId(int id);

  OrdersDto findByCustomerIdAndMaxOrderId(int customerId);

}
