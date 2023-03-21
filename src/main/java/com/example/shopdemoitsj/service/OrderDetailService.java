package com.example.shopdemoitsj.service;

import com.example.shopdemoitsj.dto.OrderDetailDto;
import com.example.shopdemoitsj.exception.OrderDetailNotFoundException;
import java.util.List;

/** service. */
public interface OrderDetailService {
  OrderDetailDto save(OrderDetailDto dto);

  OrderDetailDto findById(int id) throws OrderDetailNotFoundException;

  List<OrderDetailDto> findByOrderId(int id);
}
