package com.example.shopdemoitsj.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.shopdemoitsj.dto.OrderDetailDto;
import com.example.shopdemoitsj.mapper.OrderDetailMapper;
import com.example.shopdemoitsj.model.Customer;
import com.example.shopdemoitsj.model.Item;
import com.example.shopdemoitsj.model.OrderDetail;
import com.example.shopdemoitsj.model.Orders;
import com.example.shopdemoitsj.repository.OrderDetailRepository;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class OrderDetailServiceImplTest {

  @Mock OrderDetailRepository orderDetailRepository;

  @InjectMocks OrderDetailServiceImpl orderDetailService;

  OrderDetail orderDetail;
  OrderDetailDto orderDetailDto;

  @BeforeEach
  void init() {
    Orders orders = new Orders(1, new Customer(1, "hoa", "123", 1), new Date());
    Item item = new Item(1, "go", 123);
    orderDetail = new OrderDetail(1, orders, item, 2);
    orderDetailDto = OrderDetailMapper.getInstance().toDto(orderDetail);
  }

  @AfterEach
  void clean() {
    orderDetail = null;
    orderDetailDto = null;
  }

  @Test
  void whenSave_thenReturnTrue() {
    when(orderDetailRepository.save(orderDetail)).thenReturn(orderDetail);
    OrderDetailDto result = orderDetailService.save(orderDetailDto);
    assertThat(result).isNotNull().isEqualTo(orderDetailDto);
    verify(orderDetailRepository).save(orderDetail);
  }

  @Test
  void whenFindById_thenReturnOrderDetail() {
    when(orderDetailRepository.findById(orderDetail.getId()))
        .thenReturn(java.util.Optional.of(orderDetail));

    OrderDetailDto result = orderDetailService.findById(orderDetail.getId());

    assertThat(result).isNotNull().isEqualTo(orderDetailDto);

    verify(orderDetailRepository).findById(orderDetail.getId());
  }
}
