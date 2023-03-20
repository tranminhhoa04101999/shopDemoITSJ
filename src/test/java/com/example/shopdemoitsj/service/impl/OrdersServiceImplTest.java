package com.example.shopdemoitsj.service.impl;


import com.example.shopdemoitsj.dto.OrdersDto;
import com.example.shopdemoitsj.exception.ItemNotFoundException;
import com.example.shopdemoitsj.exception.OrdersNotFoundException;
import com.example.shopdemoitsj.mapper.ItemMapper;
import com.example.shopdemoitsj.mapper.OrdersMapper;
import com.example.shopdemoitsj.model.Customer;
import com.example.shopdemoitsj.model.Item;
import com.example.shopdemoitsj.model.Orders;
import com.example.shopdemoitsj.repository.OrdersRepository;
import java.util.Date;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class OrdersServiceImplTest {

  @Mock
  OrdersRepository ordersRepository;
  @InjectMocks OrdersServiceImpl ordersService;

  Orders orders;
  OrdersDto ordersDto;

  @BeforeEach
  void init() {
    orders = new Orders(1, new Customer(1,"hoa","123",1),new Date());
    ordersDto = OrdersMapper.getInstance().toDto(orders);
  }

  @AfterEach
  void clean() {
    orders = null;
    ordersDto = null;
  }


  @Test
  void whenSave_thenReturnOrders() {
    when(ordersRepository.save(orders)).thenReturn(orders);

    OrdersDto result = ordersService.saveOrder(ordersDto);

    assertThat(result).isNotNull().isEqualTo(ordersDto);

    verify(ordersRepository).save(orders);
  }

  @Test
  void whenFindById_thenThrowException() {
    int invalidItemId = 12312;

    when(ordersRepository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(null));

    assertThatThrownBy(() -> ordersService.findById(invalidItemId))
        .isInstanceOf(OrdersNotFoundException.class);

    verify(ordersRepository).findById(any(Integer.class));
  }

  @Test
  void givenId_whenDelete_thenReturnTrue() {
    // precodition
    when(ordersRepository.findById(orders.getId())).thenReturn(Optional.of(orders));
    doNothing().when(ordersRepository).deleteById(orders.getId());
    // when
    ordersService.delete(orders.getId());
    // then
    verify(ordersRepository, times(1)).deleteById(orders.getId());
  }
}