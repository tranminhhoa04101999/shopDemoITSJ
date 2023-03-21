package com.example.shopdemoitsj.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.example.shopdemoitsj.dto.OrdersDto;
import com.example.shopdemoitsj.mapper.OrdersMapper;
import com.example.shopdemoitsj.model.Customer;
import com.example.shopdemoitsj.model.Orders;
import com.example.shopdemoitsj.service.impl.OrdersServiceImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class OrderControllerTest {

  @Mock OrdersServiceImpl ordersService;
  @InjectMocks OrdersController ordersController;

  Orders orders;
  OrdersDto ordersDto;

  @BeforeEach
  void init() {
    Customer customer = new Customer(1, "hoa", "123", 1);
    orders = new Orders(1, customer, new Date());
    ordersDto = OrdersMapper.getInstance().toDto(orders);
  }

  @AfterEach
  void clean() {
    orders = null;
    ordersDto = null;
  }

  @Test
  @DisplayName("JUnit test find by customer id")
  void findByCustomerId() {
    List<OrdersDto> ordersDtoList = new ArrayList<>();
    Customer customer = new Customer(1, "hoa", "123", 1);
    Orders orders2 = new Orders(2, customer, new Date());
    ordersDtoList.add(OrdersMapper.getInstance().toDto(orders2));
    ordersDtoList.add(ordersDto);

    when(ordersService.findByCustomerId(orders.getCustomer().getId())).thenReturn(ordersDtoList);

    ResponseEntity<List<OrdersDto>> result =
        ordersController.findByCustomerId(orders.getCustomer().getId());

    assertThat(result.getBody()).hasSameSizeAs(ordersDtoList);
    assertThat(result.getBody()).hasSameElementsAs(ordersDtoList);
  }

  @Test
  @DisplayName("find by customer id va max order id ")
  void findByCustomerIdAndMaxOrderId() {
    when(ordersService.findByCustomerIdAndMaxOrderId(orders.getCustomer().getId()))
        .thenReturn(ordersDto);

    ResponseEntity<OrdersDto> result =
        ordersController.findByCustomerIdAndMaxOrderId(orders.getCustomer().getId());

    assertThat(result.getBody()).isNotNull();
    assertThat(result.getBody().getCustomerDto().getUsername())
        .isEqualTo(ordersDto.getCustomerDto().getUsername());
  }
}
