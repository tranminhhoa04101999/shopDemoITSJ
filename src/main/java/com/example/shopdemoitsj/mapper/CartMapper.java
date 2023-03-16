package com.example.shopdemoitsj.mapper;

import com.example.shopdemoitsj.dto.CartDetailDto;
import com.example.shopdemoitsj.dto.CartDto;
import com.example.shopdemoitsj.model.Cart;
import java.util.List;

/**
 * mapper.
 * */
public class CartMapper {
  private static CartMapper instance;

  /**
   * instance.
   * */
  public static CartMapper getInstance() {
    if (instance == null) {
      instance = new CartMapper();
    }
    return instance;
  }
  /**
   * chuyen doi tu cart qua entity.
   * */

  public Cart toEntity(CartDto cartDto) {
    Cart cart = new Cart();
    cart.setId(cartDto.getId());
    cart.setCustomer(CustomerMapper.getInstance().toEntity(cartDto.getCustomerDto()));
    return cart;
  }

  /**
   * chuyen doi qua dto.
   * */
  public CartDto toDto(Cart cart, List<CartDetailDto> cartDetailDtoList) {
    CartDto toDto = new CartDto();
    toDto.setId(cart.getId());
    toDto.setCustomerDto(CustomerMapper.getInstance().toDto(cart.getCustomer()));
    toDto.setCartDetailDtos(cartDetailDtoList);
    return toDto;
  }
}
