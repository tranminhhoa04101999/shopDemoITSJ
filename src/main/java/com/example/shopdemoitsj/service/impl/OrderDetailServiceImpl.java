package com.example.shopdemoitsj.service.impl;

import com.example.shopdemoitsj.dto.OrderDetailDto;
import com.example.shopdemoitsj.exception.OrderDetailNotFoundException;
import com.example.shopdemoitsj.mapper.OrderDetailMapper;
import com.example.shopdemoitsj.model.OrderDetail;
import com.example.shopdemoitsj.repository.OrderDetailRepository;
import com.example.shopdemoitsj.service.OrderDetailService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** service. */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

  @Autowired OrderDetailRepository orderDetailRepository;

  @Override
  public OrderDetailDto save(OrderDetailDto dto) {
    OrderDetail orderDetail = OrderDetailMapper.getInstance().toEntity(dto);
    return OrderDetailMapper.getInstance().toDto(orderDetailRepository.save(orderDetail));
  }

  @Override
  public OrderDetailDto findById(int id) throws OrderDetailNotFoundException {
    OrderDetail orderDetail;
    Optional<OrderDetail> optional = orderDetailRepository.findById(id);
    orderDetail = optional.orElseGet(OrderDetail::new);

    if (optional.isPresent()) {
      return OrderDetailMapper.getInstance().toDto(orderDetail);
    } else {
      throw new OrderDetailNotFoundException();
    }
  }

  @Override
  public List<OrderDetailDto> findByOrderId(int orderId) {
    return orderDetailRepository.findByOrdersId(orderId).stream()
        .map(temp -> OrderDetailMapper.getInstance().toDto(temp))
        .collect(Collectors.toList());
  }
}
