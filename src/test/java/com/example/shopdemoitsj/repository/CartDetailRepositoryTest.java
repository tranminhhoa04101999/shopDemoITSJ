package com.example.shopdemoitsj.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.shopdemoitsj.model.Cart;
import com.example.shopdemoitsj.model.CartDetail;
import com.example.shopdemoitsj.model.Customer;
import com.example.shopdemoitsj.model.Item;
import java.util.Date;
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
class CartDetailRepositoryTest {

  @Autowired CartDetailRepository cartDetailRepository;
  @Autowired CartRepository cartRepository;

  private CartDetail cartDetailInstance;

  @BeforeEach
  void init() {
    Customer customer = new Customer(1, "hoa", "123456", 1);
    Cart cart = new Cart(1, customer);
    Item item = new Item(1, "hoa", 100);
    CartDetail cartDetail = new CartDetail(1, cart, item, 2, new Date());
    cartDetailInstance = cartDetail;
  }

  @Test
  @DisplayName("JUnit test save cart detail")
  void whenSave_thenReturnSaveCartDetail() {
    CartDetail result = cartDetailRepository.save(cartDetailInstance);

    assertThat(result).isNotNull();
    assertThat(result.getId()).isPositive();
  }
  //    @Test
  //    @DisplayName("JUnit test find all cart detail")
  //    void whenFindAll_thenReturnAllCartDetail() {
  //
  //      Customer customer = new Customer(2,"hoa","123456",1);
  //      Cart cart = new Cart(2,customer);
  //      Item item = new Item(2,"go",200);
  //      CartDetail cartDetail = new CartDetail(2,cart,item,2,new Date());
  //      cartDetailRepository.save(cartDetailInstance);
  //      cartDetailRepository.save(cartDetail);
  //
  //      List<CartDetail> result = cartDetailRepository.findAll();
  //      assertThat(result).hasSize(2);
  //    }

  @Test
  @DisplayName("JUnit test update cart details")
  void whenUpdate_thenReturnUpdateCartDetail() {
    CartDetail cartDetail = cartDetailInstance;
    cartDetailRepository.save(cartDetail);

    int newQuantity = 3;
    cartDetail.setQuantity(newQuantity);
    cartDetailRepository.save(cartDetail);
    CartDetail result = cartDetailRepository.findById(cartDetail.getId()).get();

    assertThat(result).isNotNull();
    assertThat(result.getQuantity()).isEqualTo(newQuantity);
  }

  @Test
  @DisplayName("JUnit test delete cart detail")
  void whenDelete_thenRemoveCartDetail() {
    CartDetail cartDetail = cartDetailInstance;
    CartDetail cartDetailTest = cartDetailRepository.save(cartDetail);
    cartDetailRepository.deleteById(cartDetailTest.getId());
    Optional<CartDetail> result = cartDetailRepository.findById(cartDetailTest.getId());
    assertThat(result).isEmpty();
  }

  @Test
  @DisplayName("JUnit test find by cartId")
  void whenFindByCartId_thenReturnCartDetail() {
    CartDetail cartDetail = cartDetailInstance;
    CartDetail cartDetailTest = cartDetailRepository.save(cartDetail);
    List<CartDetail> result = cartDetailRepository.findByCartId(cartDetailTest.getCart().getId());
    assertThat(result).contains(cartDetailTest);
  }
}
