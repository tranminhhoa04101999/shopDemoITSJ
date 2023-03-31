package com.example.shopdemoitsj.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.example.shopdemoitsj.dto.OrderDetailDto;
import com.example.shopdemoitsj.exception.OrderDetailNotFoundException;
import com.example.shopdemoitsj.mapper.OrderDetailMapper;
import com.example.shopdemoitsj.model.Customer;
import com.example.shopdemoitsj.model.Item;
import com.example.shopdemoitsj.model.OrderDetail;
import com.example.shopdemoitsj.model.Orders;
import com.example.shopdemoitsj.service.impl.OrderDetailServiceImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
class OrderDetailControllerTest {
  @Mock OrderDetailServiceImpl orderDetailService;
  @InjectMocks OrderDetailController orderDetailController;

  OrderDetail orderDetail;
  OrderDetailDto orderDetailDto;

  @BeforeEach
  void init() {
    Item item = new Item(1, "gio", 123);
    Customer customer = new Customer(1, "hoa", "123", 1);
    Orders orders = new Orders(1, 0,customer, new Date());
    orderDetail = new OrderDetail(1, orders, item, 2);
    orderDetailDto = OrderDetailMapper.getInstance().toDto(orderDetail);
  }

  @AfterEach
  void clean() {
    orderDetail = null;
    orderDetailDto = null;
  }

  @Test
  void findByOrderId() throws OrderDetailNotFoundException {
    Item item = new Item(2, "gio2", 123);
    Customer customer = new Customer(1, "hoa", "123", 1);
    Orders orders = new Orders(1,0, customer, new Date());
    OrderDetail orderDetail2 = new OrderDetail(2, orders, item, 2);

    List<OrderDetailDto> orderDetailDtoList = new ArrayList<>();
    orderDetailDtoList.add(OrderDetailMapper.getInstance().toDto(orderDetail2));
    orderDetailDtoList.add(orderDetailDto);

    when(orderDetailService.findByOrderId(orderDetail.getOrders().getId()))
        .thenReturn(orderDetailDtoList);

    ResponseEntity<List<OrderDetailDto>> result =
        orderDetailController.findByOrderId(orderDetail.getOrders().getId());

    assertThat(result.getBody()).isNotNull();
    assertThat(result.getBody().get(0).getQuantity())
        .isEqualTo(orderDetailDtoList.get(0).getQuantity());
  }
}
