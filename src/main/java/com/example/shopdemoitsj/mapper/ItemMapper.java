package com.example.shopdemoitsj.mapper;

import com.example.shopdemoitsj.dto.ItemDto;
import com.example.shopdemoitsj.model.Item;

/**
 * mapper.
 * */
public class ItemMapper {
  private static ItemMapper instance;

  /**
   * instance.
   * */
  public static ItemMapper getInstance() {
    if (instance == null) {
      instance = new ItemMapper();
    }
    return instance;
  }

  /**
   * step 1: chuyen dto qua entity.
   *
   * @param dto itemdto chuyen vao.
   * @Return tra ra model item.
   *
   * */

  public Item toEntity(ItemDto dto) {
    Item item = new Item();
    item.setId(dto.getId());
    item.setName(dto.getName());
    item.setPrice(dto.getPrice());
    return item;
  }

  /**
   * step 1: chuyen entity qua dto.
   *
   * @param item item model chuyen vao.
   * @Return tra ra dto item.
   *
   * */

  public ItemDto toDto(Item item) {
    ItemDto itemDto = new ItemDto();
    itemDto.setId(item.getId());
    itemDto.setName(item.getName());
    itemDto.setPrice(item.getPrice());
    return itemDto;
  }
}
