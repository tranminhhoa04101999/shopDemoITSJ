package com.example.shopdemoitsj.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.shopdemoitsj.model.Cart;
import com.example.shopdemoitsj.model.Customer;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class CartRepositoryTest {

  @Autowired CartRepository cartRepository;

  private Cart cartInstance;

  @BeforeEach
  void init() {
    Customer customer = new Customer(1, "hoa", "123456", 1);
    Cart cart = new Cart(1, customer);
    cartInstance = cart;
  }

  @Test
  @DisplayName("JUnit test save cart")
  void whenSave_thenReturnSaveCart() {
    Cart result = cartRepository.save(cartInstance);

    assertThat(result).isNotNull();
    assertThat(result.getId()).isPositive();
  }

  @Test
  @DisplayName("JUnit test find all cart")
  void whenFindAll_thenReturnAllCart() {

    Cart cart1 = new Cart(1, new Customer(1, "hoa", "123456", 1));
    Cart cart2 = new Cart(2, new Customer(2, "hoa", "123456", 1));

    cartRepository.save(cart1);
    cartRepository.save(cart2);

    List<Cart> result = cartRepository.findAll();
    assertThat(result).hasSize(2);
  }

  @Test
  @DisplayName("JUnit test delete cart")
  void whenDelete_thenRemoveCart() {
    Cart cart = cartInstance;
    Cart cartTest = cartRepository.save(cart);
    cartRepository.deleteById(cartTest.getId());
    Optional<Cart> result = cartRepository.findById(cartTest.getId());
    assertThat(result).isEmpty();
  }

  @Test
  @DisplayName("JUnit test find by customer id")
  void whenFindByCustomerId_thenReturnCart() {
    Cart cart = cartInstance;
    Cart cartTest = cartRepository.save(cart);

    Cart result = cartRepository.findByCustomerId(cartTest.getCustomer().getId());
    assertThat(result).isEqualTo(cartTest);
  }

  @Test
  @DisplayName("JUnit test find by id")
  void whenFindById_thenReturnCart() {
    Cart cart = cartInstance;
    Cart cartTest = cartRepository.save(cart);

    Cart result = cartRepository.findById(cartTest.getId()).get();
    assertThat(result).isEqualTo(cartTest);
  }
}
