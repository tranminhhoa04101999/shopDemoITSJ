package com.example.shopdemoitsj.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *  dto.
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto implements Serializable {
  private int id;
  private String name;
  private double price;

}
