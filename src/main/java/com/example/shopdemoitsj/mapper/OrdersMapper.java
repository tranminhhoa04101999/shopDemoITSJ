package com.example.shopdemoitsj.mapper;


import com.example.shopdemoitsj.dto.OrdersDto;
import com.example.shopdemoitsj.model.Orders;


/**
 * mapper.
 * */
public class OrdersMapper {
  /** The constant INSTANCE. */

  private static OrdersMapper instance;
  /**
   * Gets instance.
   *
   * @return the instance
   */

  public static OrdersMapper getInstance() {
    if (instance == null) {
      instance = new OrdersMapper();
    }
    return instance;
  }
  /**
   * To entity.
   *
   * @param dto the item dto
   * @return the order entity
   */

  public Orders toEntity(OrdersDto dto) {
    Orders orders = new Orders();
    orders.setId(dto.getId());
    orders.setStatus(dto.getStatus());
    orders.setCustomer(CustomerMapper.getInstance().toEntity(dto.getCustomerDto()));
    orders.setOrderDate(dto.getOrderDate());
    return orders;
  }
  /**
   * To dto.
   *
   * @param orders the item dto
   * @return the order dto
   */

  public OrdersDto toDto(Orders orders) {
    OrdersDto orderDto = new OrdersDto();
    orderDto.setId(orders.getId());
    orderDto.setStatus(orders.getStatus());
    orderDto.setCustomerDto(CustomerMapper.getInstance().toDto(orders.getCustomer()));
    orderDto.setOrderDate(orders.getOrderDate());

    return orderDto;
  }

}
