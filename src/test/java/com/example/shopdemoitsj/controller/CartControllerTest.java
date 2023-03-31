package com.example.shopdemoitsj.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.example.shopdemoitsj.dto.AddToCartDto;
import com.example.shopdemoitsj.dto.CartDetailDto;
import com.example.shopdemoitsj.dto.CartDto;
import com.example.shopdemoitsj.dto.ItemDto;
import com.example.shopdemoitsj.exception.CartDetailNotFoundException;
import com.example.shopdemoitsj.exception.QuantityLessThanOneException;
import com.example.shopdemoitsj.mapper.CartMapper;
import com.example.shopdemoitsj.model.Cart;
import com.example.shopdemoitsj.model.Customer;
import com.example.shopdemoitsj.repository.CartDetailRepository;
import com.example.shopdemoitsj.service.impl.CartDetailServiceImpl;
import com.example.shopdemoitsj.service.impl.CartServiceImpl;
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
import org.springframework.test.context.TestPropertySource;

/**
 * test controller cart.
 * */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@TestPropertySource("classpath:test.properties")
 class CartControllerTest {
  @Mock CartServiceImpl cartService;
  @InjectMocks CartController cartController;

  @Mock CartDetailServiceImpl cartDetailService;

  @Mock CartDetailRepository cartDetailRepository;

  Cart cart;
  CartDto cartDto;
  AddToCartDto addToCartDto;

  @BeforeEach
  void init() {
    Customer customer = new Customer(1, "hoa", "123", 1);
    cart = new Cart(1, customer);
    List<CartDetailDto> cartDetailDtoList = new ArrayList<>();

    cartDto = CartMapper.getInstance().toDto(cart, cartDetailDtoList);
  }

  @AfterEach
  void clean() {
    cart = null;
    cartDto = null;
    addToCartDto = null;
  }

  @Test
  @DisplayName("Junit test find by id customer")
  void findById() throws CartDetailNotFoundException {
    when(cartController.findById(cart.getCustomer().getId())).thenReturn(cartDto);

    CartDto result = cartService.findByCustomerId(cartDto.getCustomerDto().getId());

    assertThat(result).isNotNull().isEqualTo(cartDto);
  }

  @Test
  @DisplayName("JUnit test add item to cart")
  void addToCart() {
    ItemDto itemDto = new ItemDto(1, "go", 123);
    CartDetailDto cartDetailDto = new CartDetailDto(1, itemDto, cartDto, 2, new Date());
    AddToCartDto addToCartDto = new AddToCartDto(itemDto.getId(), 2, cart.getCustomer().getId());

    when(cartDetailService.add(addToCartDto)).thenReturn(cartDetailDto);

    ResponseEntity<CartDetailDto> result = cartController.addToCart(addToCartDto);

    assertThat(result.getBody()).isNotNull();
    assertThat(result.getBody().getItemDto().getName())
        .isEqualTo(cartDetailDto.getItemDto().getName());
  }

  @Test
  @DisplayName("JUnit update item in cart")
  void updateItemInCart() throws QuantityLessThanOneException {
    ItemDto itemDto = new ItemDto(1, "go", 123);
    CartDetailDto cartDetailDto = new CartDetailDto(1, itemDto, cartDto, 2, new Date());

    when(cartDetailService.update(cartDetailDto)).thenReturn(cartDetailDto);

    cartDetailDto.setQuantity(10);

    ResponseEntity<CartDetailDto> result = cartController.updateCartDetail(cartDetailDto);

    assertThat(result.getBody()).isNotNull();
    assertThat(result.getBody().getQuantity()).isEqualTo(cartDetailDto.getQuantity());
  }
}
