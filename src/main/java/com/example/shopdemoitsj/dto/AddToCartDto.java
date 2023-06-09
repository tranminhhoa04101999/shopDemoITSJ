package com.example.shopdemoitsj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** getter getter constructor. */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddToCartDto {
  private int itemId;
  private int quantity;
  private int customerId;
}
