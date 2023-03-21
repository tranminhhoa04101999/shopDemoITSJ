package com.example.shopdemoitsj.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * dto.
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDto implements Serializable {

  private int id;
  private OrdersDto ordersDto;
  private ItemDto itemDto;
  private int quantity;
}
