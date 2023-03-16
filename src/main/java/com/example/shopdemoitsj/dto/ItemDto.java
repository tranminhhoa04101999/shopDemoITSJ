package com.example.shopdemoitsj.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *  dto.
 * */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto implements Serializable {

  private int id;
  private String name;
  private double price;

  public ItemDto(int id) {
    this.id = id;
  }
}
