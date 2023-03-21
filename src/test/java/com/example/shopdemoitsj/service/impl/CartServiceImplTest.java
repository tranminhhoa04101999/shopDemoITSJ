package com.example.shopdemoitsj.service.impl;

import com.example.shopdemoitsj.dto.CartDetailDto;
import com.example.shopdemoitsj.dto.CartDto;
import com.example.shopdemoitsj.mapper.CartMapper;
import com.example.shopdemoitsj.model.Cart;
import com.example.shopdemoitsj.model.CartDetail;
import com.example.shopdemoitsj.model.Customer;
import com.example.shopdemoitsj.model.Item;
import com.example.shopdemoitsj.repository.CartDetailRepository;
import com.example.shopdemoitsj.repository.CartRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CartServiceImplTest {
  @Mock CartRepository cartRepository;
  @Mock CartDetailRepository cartDetailRepository;

  @InjectMocks CartServiceImpl cartService;
  @InjectMocks CartDetailServiceImpl cartDetailService;

  Cart cart;
  CartDto cartDto;
  Customer customer;
  List<CartDetail> cartDetailList = new ArrayList<>();

  @BeforeEach
  void init() {
    customer = new Customer(1, "hoa", "password", 1);
    cart = new Cart(1, customer);
    List<CartDetailDto> cartDetailDtoList = new ArrayList<>();
    cartDto = CartMapper.getInstance().toDto(cart, cartDetailDtoList);

    cartDetailList.add(new CartDetail(1, cart, new Item(1, "ban", 1000), 2, new Date()));
  }

  @AfterEach
  void clean() {
    cart = null;
    cartDto = null;
    customer = null;
    cartDetailList = null;
  }
  //  @Test
  //  void whenFindByCustomerId_thenReturnCart() {
  //    when(cartRepository.findByCustomerId(customer.getId())).thenReturn(cart);
  //    when(cartDetailRepository.findByCartId(cart.getId())).thenReturn(cartDetailList);
  //
  //    CartDto result = cartService.findByCustomerId(customer.getId());
  //
  ////    assertThat(result).isNotNull();
  //  }

}
