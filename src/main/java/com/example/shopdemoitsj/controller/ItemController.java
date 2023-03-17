package com.example.shopdemoitsj.controller;

import com.example.shopdemoitsj.dto.ItemDto;
import com.example.shopdemoitsj.exception.ItemNotFoundException;
import com.example.shopdemoitsj.service.impl.ItemServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  sản phẩm controller.
 * */
@RestController
@RequestMapping("/api")
public class ItemController {
  @Autowired private ItemServiceImpl itemServiceImpl;

  @GetMapping("/items")
  public ResponseEntity<List<ItemDto>> getItems() {
    return new ResponseEntity<>(itemServiceImpl.findAll(), HttpStatus.OK);
  }

  @GetMapping("/items/{itemId}")
  public ResponseEntity<ItemDto> getItemById(@PathVariable int itemId)
      throws ItemNotFoundException {
    return new ResponseEntity<>(itemServiceImpl.findById(itemId), HttpStatus.OK);
  }
  /// save item coi lai id

  @PostMapping("/items")
  public ResponseEntity<HttpStatus> save(@RequestBody ItemDto itemDto) {
    itemServiceImpl.saveItem(itemDto);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping("/items")
  public ResponseEntity<HttpStatus> update(@RequestBody ItemDto itemDto) {
    itemServiceImpl.saveItem(itemDto);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/items/{itemId}")
  public ResponseEntity<HttpStatus> delete(@PathVariable int itemId) {
    itemServiceImpl.delete(itemId);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
