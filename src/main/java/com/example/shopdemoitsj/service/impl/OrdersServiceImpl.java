package com.example.shopdemoitsj.service.impl;

import com.example.shopdemoitsj.repository.OrdersRepository;
import com.example.shopdemoitsj.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * service.
 * */
@Service
public class OrdersServiceImpl implements OrdersService {
  @Autowired OrdersRepository ordersRepository;


}
