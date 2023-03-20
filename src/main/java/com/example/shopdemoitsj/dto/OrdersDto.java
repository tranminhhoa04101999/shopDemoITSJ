package com.example.shopdemoitsj.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * chuyển đổi dữ liệu giỏ hàng qua dto.
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDto implements Serializable {
  private int id;
  private CustomerDto customerDto;
  private Date orderdate;
}
