package com.example.shopdemoitsj.mapper;

import com.example.shopdemoitsj.dto.ItemDto;
import com.example.shopdemoitsj.dto.OrderDetailDto;
import com.example.shopdemoitsj.model.Item;
import com.example.shopdemoitsj.model.OrderDetail;

/** mapper. */
public class OrderDetailMapper {
  /** The constant INSTANCE. */
  private static OrderDetailMapper instance;

  /**
   * Gets instance.
   *
   * @return the instance
   */
  public static OrderDetailMapper getInstance() {
    if (instance == null) {
      instance = new OrderDetailMapper();
    }
    return instance;

  }
  /**
   * To entity.
   *
   * @param dto the  dto
   * @return the entity
   */
  public OrderDetail toEntity(OrderDetailDto dto) {
    OrderDetail orderDetail = new OrderDetail();
    orderDetail.setId(dto.getId());
    orderDetail.setOrders(OrdersMapper.getInstance().toEntity(dto.getOrdersDto()));
    orderDetail.setItem(ItemMapper.getInstance().toEntity(dto.getItemDto()));
    orderDetail.setQuantity(dto.getQuantity());

    return orderDetail;
  }

  /**
   * To dto.
   *
   * @param orderDetail the item
   * @return the dto
   */
  public OrderDetailDto toDto(OrderDetail orderDetail) {
    OrderDetailDto dto = new OrderDetailDto();
    dto.setId(orderDetail.getId());
    dto.setOrdersDto(OrdersMapper.getInstance().toDto(orderDetail.getOrders()));
    dto.setItemDto(ItemMapper.getInstance().toDto(orderDetail.getItem()));
    dto.setQuantity(orderDetail.getQuantity());
    return dto;
  }
}
