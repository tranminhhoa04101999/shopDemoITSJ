package com.example.shopdemoitsj.service;

import com.example.shopdemoitsj.dto.CartDto;
import com.example.shopdemoitsj.dto.OrdersDto;
import com.example.shopdemoitsj.exception.EmptyCartException;
import com.example.shopdemoitsj.exception.OrderFalse;
import com.example.shopdemoitsj.exception.OrdersNotFoundException;
import java.util.List;

/** service. */
public interface OrdersService {
  OrdersDto saveOrder(OrdersDto ordersDto);

  void placeAnOrder(CartDto cartDto) throws OrderFalse, EmptyCartException;

  OrdersDto findById(int id) throws OrdersNotFoundException;

  void delete(int id);

  List<OrdersDto> findByCustomerId(int id);

  OrdersDto findByCustomerIdAndMaxOrderId(int customerId);

  List<OrdersDto> findAll();
}
