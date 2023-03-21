package com.example.shopdemoitsj.mapper;

import com.example.shopdemoitsj.dto.CartDetailDto;
import com.example.shopdemoitsj.model.CartDetail;

/**
 *  mapper.
 * */
public class CartDetailMapper {
  private static CartDetailMapper instance;

  /**
   *  intansce.
   * */
  public static CartDetailMapper getInstance() {
    if (instance == null) {
      instance = new CartDetailMapper();
    }
    return instance;
  }

  /**
   *  todto.
   * */
  public CartDetailDto toDto(CartDetail cartDetail) {
    CartDetailDto cartDetailDto = new CartDetailDto();
    cartDetailDto.setId(cartDetail.getId());
    cartDetailDto.setItemDto(ItemMapper.getInstance().toDto(cartDetail.getItem()));
    cartDetailDto.setQuantity(cartDetail.getQuantity());
    cartDetailDto.setDateAdded(cartDetail.getDateAdded());

    return cartDetailDto;
  }
  /**
   *  to entity.
   * */

  public CartDetail toEntity(CartDetailDto dto) {
    CartDetail cartDetail = new CartDetail();
    cartDetail.setId(dto.getId());
    cartDetail.setCart(CartMapper.getInstance().toEntity(dto.getCartDto()));
    cartDetail.setItem(ItemMapper.getInstance().toEntity(dto.getItemDto()));
    cartDetail.setQuantity(dto.getQuantity());
    cartDetail.setDateAdded(dto.getDateAdded());
    return cartDetail;
  }
}
