package com.example.shopdemoitsj.service;

import com.example.shopdemoitsj.dto.OrderDetailDto;
import com.example.shopdemoitsj.model.OrderDetail;

/**
 * service.
 * */
public interface OrderDetailService {
  OrderDetailDto save(OrderDetailDto dto);

  OrderDetailDto findById(int id);

}
