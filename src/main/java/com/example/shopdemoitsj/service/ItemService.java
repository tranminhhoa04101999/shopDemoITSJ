package com.example.shopdemoitsj.service;

import com.example.shopdemoitsj.dto.ItemDto;
import com.example.shopdemoitsj.exception.ItemCascadeDeleteError;
import com.example.shopdemoitsj.exception.ItemNotFoundException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/** item service interface. */
public interface ItemService {
  List<ItemDto> findAll();

  ItemDto findById(int id) throws ItemNotFoundException;

  ItemDto saveItem(ItemDto itemDto);

  ResponseEntity<HttpStatus> delete(int itemId) throws ItemCascadeDeleteError, Exception;
}
