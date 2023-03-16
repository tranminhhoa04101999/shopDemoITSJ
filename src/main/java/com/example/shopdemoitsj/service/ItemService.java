package com.example.shopdemoitsj.service;

import com.example.shopdemoitsj.dto.ItemDto;
import com.example.shopdemoitsj.exception.ItemNotFoundException;
import java.util.List;

/**
 * item service interface.
 * */
public interface ItemService {
  List<ItemDto> findAll();

  ItemDto findById(int id) throws ItemNotFoundException;

  void save(ItemDto itemDto);

  void delete(int itemId);
}
