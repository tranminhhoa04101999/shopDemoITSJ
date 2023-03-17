package com.example.shopdemoitsj.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.shopdemoitsj.model.Item;
import com.example.shopdemoitsj.model.OrderDetail;
import com.example.shopdemoitsj.model.Orders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class OrderDetailRepositoryTest {
  @Autowired OrderDetailRepository orderDetailRepository;

  private OrderDetail orderDetailInstance;

  @BeforeEach
  void init() {
    OrderDetail orderDetail = new OrderDetail(1, new Orders(), new Item(1, "hoa", 192), 2);
    orderDetailInstance = orderDetail;
  }

  @Test
  @DisplayName("JUnit test save order detail")
  void whenSave_thenReturnSaveOrderDetail() {
    OrderDetail orderDetail = orderDetailRepository.save(orderDetailInstance);

    assertThat(orderDetail).isNotNull();
    assertThat(orderDetail.getId()).isPositive();
  }

  //  @Test
  //  @DisplayName("JUnit test find all")
  //  void whenFindAll_thenReturnAllOrderDetails() {
  //
  //    OrderDetail orderDetail = new OrderDetail(2, new Orders(), new Item(1), 2);
  //
  //    orderDetailRepository.save(orderDetail);
  //    orderDetailRepository.save(orderDetailInstance);
  //
  //    List<OrderDetail> result = orderDetailRepository.findAll();
  //    assertThat(result).hasSize(2);
  //  }

  @Test
  @DisplayName("JUnit test find by id")
  void whenFindById_thenReturnOrderDetail() {
    OrderDetail orderDetail = orderDetailInstance;
    OrderDetail orderDetailTest = orderDetailRepository.save(orderDetail);
    OrderDetail result = orderDetailRepository.findById(orderDetailTest.getId()).get();
    assertThat(result).isEqualTo(orderDetailTest);
  }

  @Test
  @DisplayName("JUnit test update order detail")
  void whenUpdate_thenReturnUpdateOrderDetail() {
    OrderDetail orderDetail = orderDetailInstance;
    OrderDetail orderDetailTest = orderDetailRepository.save(orderDetail);

    int newQuantity = 112;
    orderDetailTest.setQuantity(newQuantity);
    orderDetailRepository.save(orderDetailTest);
    OrderDetail result = orderDetailRepository.findById(orderDetailTest.getId()).get();

    assertThat(result).isNotNull();
    assertThat(result.getQuantity()).isEqualTo(newQuantity);
  }
}
