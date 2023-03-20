package com.example.shopdemoitsj.service.impl;

import com.example.shopdemoitsj.dto.OrderDetailDto;
import com.example.shopdemoitsj.mapper.OrderDetailMapper;
import com.example.shopdemoitsj.model.OrderDetail;
import com.example.shopdemoitsj.repository.OrderDetailRepository;
import com.example.shopdemoitsj.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * service.
 * */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

  @Autowired
  OrderDetailRepository orderDetailRepository;

  @Override
  public OrderDetailDto save(OrderDetailDto dto) {
    OrderDetail orderDetail = OrderDetailMapper.getInstance().toEntity(dto);
    return OrderDetailMapper.getInstance().toDto(orderDetailRepository.save(orderDetail));
  }

  @Override
  public OrderDetailDto findById(int id) {
    return OrderDetailMapper.getInstance().toDto(orderDetailRepository.findById(id).get());
  }
}
