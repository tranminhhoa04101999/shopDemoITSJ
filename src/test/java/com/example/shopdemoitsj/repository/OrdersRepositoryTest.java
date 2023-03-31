package com.example.shopdemoitsj.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.shopdemoitsj.model.Customer;
import com.example.shopdemoitsj.model.Orders;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class OrdersRepositoryTest {

  @Autowired OrdersRepository ordersRepository;

  private Orders ordersInstance;

  @BeforeEach
  void init() {
    Customer customer = new Customer(1, "name", "password", 0);
    Orders orders = new Orders(1,0, customer, new Date());
    ordersInstance = orders;
  }

  @Test
  @DisplayName("JUnit test save order")
  void whenSave_thenReturnSaveOrder() {
    Orders orders = ordersRepository.save(ordersInstance);

    assertThat(orders).isNotNull();
    assertThat(orders.getId()).isPositive();
  }

  @Test
  @DisplayName("JUnit test find all")
  void whenFindAll_thenReturnAllOrder() {

    Customer customer = new Customer(2, "name", "password", 0);
    Orders orders = new Orders(2, 0,customer, new Date());

    ordersRepository.save(orders);
    ordersRepository.save(ordersInstance);

    List<Orders> result = ordersRepository.findAll();
    assertThat(result).hasSize(2);
  }

  @Test
  @DisplayName("JUnit test find by id")
  void whenFindById_thenReturnOrder() {
    Orders orders = ordersInstance;
    Orders ordersTest = ordersRepository.save(orders);
    Orders result = ordersRepository.findById(ordersTest.getId()).get();
    assertThat(result).isEqualTo(ordersTest);
  }

  @Test
  @DisplayName("JUnit test update order")
  void whenUpdate_thenReturnUpdateOrder() {
    Orders orders = ordersInstance;
    Orders orders1 = ordersRepository.save(orders);

    Date newDate = new Date();
    orders1.setOrderDate(newDate);
    ordersRepository.save(orders);
    Orders result = ordersRepository.findById(orders1.getId()).get();

    assertThat(result).isNotNull();
    assertThat(result.getOrderDate()).hasSameTimeAs(newDate);
  }
}
