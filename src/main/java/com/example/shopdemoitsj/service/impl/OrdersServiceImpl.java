package com.example.shopdemoitsj.service.impl;

import com.example.shopdemoitsj.dto.OrdersDto;
import com.example.shopdemoitsj.exception.OrdersNotFoundException;
import com.example.shopdemoitsj.mapper.OrdersMapper;
import com.example.shopdemoitsj.model.Orders;
import com.example.shopdemoitsj.repository.OrdersRepository;
import com.example.shopdemoitsj.service.OrdersService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** service. */
@Service
public class OrdersServiceImpl implements OrdersService {
  @Autowired OrdersRepository ordersRepository;

  @Override
  public OrdersDto saveOrder(OrdersDto ordersDto) {
    Orders orders = OrdersMapper.getInstance().toEntity(ordersDto);
    return OrdersMapper.getInstance().toDto(ordersRepository.save(orders));
  }

  @Override
  public OrdersDto findById(int id) throws OrdersNotFoundException {
    Orders orders;
    Optional<Orders> ordersOptional = ordersRepository.findById(id);
    orders = ordersOptional.orElseGet(Orders::new);

    if (ordersOptional.isPresent()) {
      return OrdersMapper.getInstance().toDto(orders);
    } else {
      throw new OrdersNotFoundException();
    }
  }

  @Override
  public void delete(int id) {
    ordersRepository.deleteById(id);
  }
}