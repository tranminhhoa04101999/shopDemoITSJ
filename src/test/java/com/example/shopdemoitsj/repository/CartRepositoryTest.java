package com.example.shopdemoitsj.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.shopdemoitsj.model.Cart;
import com.example.shopdemoitsj.model.Customer;
import javax.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@ExtendWith(MockitoExtension.class)
@Transactional
class CartRepositoryTest {
  @Mock CartRepository cartRepository;
  @Mock CustomerRepository customerRepository;


//  @Test
//  void findByCustomerId() {
//    Cart cart = getCart();
//    customerRepository.save(cart.getCustomer());
//    cartRepository.save(cart);
//    Cart result =  cartRepository.findByCustomerId(cart.getCustomer().getId());
//    assertEquals(cart.getId(),result.getId());
//  }
//
//  private Cart getCart() {
//    Cart cart = new Cart();
//    cart.setId(1);
//    cart.setCustomer(new Customer(1));
//    return cart;
//  }
}
