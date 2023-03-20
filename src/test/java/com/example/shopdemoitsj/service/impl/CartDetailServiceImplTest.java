package com.example.shopdemoitsj.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.shopdemoitsj.dto.AddToCartDto;
import com.example.shopdemoitsj.dto.CartDetailDto;
import com.example.shopdemoitsj.dto.CartDto;
import com.example.shopdemoitsj.dto.ItemDto;
import com.example.shopdemoitsj.exception.ItemNotFoundException;
import com.example.shopdemoitsj.mapper.CartDetailMapper;
import com.example.shopdemoitsj.mapper.CartMapper;
import com.example.shopdemoitsj.mapper.ItemMapper;
import com.example.shopdemoitsj.model.Cart;
import com.example.shopdemoitsj.model.CartDetail;
import com.example.shopdemoitsj.model.Customer;
import com.example.shopdemoitsj.model.Item;
import com.example.shopdemoitsj.repository.CartDetailRepository;
import com.example.shopdemoitsj.repository.CartRepository;
import com.example.shopdemoitsj.repository.ItemRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CartDetailServiceImplTest {

  @Mock CartDetailRepository cartDetailRepository;
  @InjectMocks CartDetailServiceImpl cartDetailService;

  CartDetail cartDetail;
  CartDetailDto cartDetailDto;

  @BeforeEach
  void init() {
    Customer customer = new Customer(1,"hoa","123",0);
    Cart cart = new Cart(1,customer);
    Item item = new Item(1,"go",123);
    cartDetail = new CartDetail(1,cart,item,2,new Date());
    cartDetailDto = CartDetailMapper.getInstance().toDto(cartDetail);
  }
  @AfterEach
  void clean() {
    cartDetailDto = null;
    cartDetail =null;
  }
//
//  @Test
//  void whenAdd_thenReturnTrue() {
//    when(cartDetailRepository.save(cartDetail)).thenReturn(cartDetail);
//    AddToCartDto addToCartDto = new AddToCartDto(cartDetail.getItem().getId(),cartDetail.getQuantity(),cartDetail.getCart().getCustomer().getId());
//    CartDetailDto result = cartDetailService.add(addToCartDto);
//
//    assertThat(result).isNotNull().isEqualTo(cartDetailDto);
//  }

}


















