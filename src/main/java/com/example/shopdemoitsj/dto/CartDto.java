package com.example.shopdemoitsj.dto;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * chuyển đổi dữ liệu giỏ hàng qua dto.
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto implements Serializable {
  private int id;
  private CustomerDto customerDto;
  private List<CartDetailDto> cartDetailDtos;
}
