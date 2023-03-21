package com.example.shopdemoitsj.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.shopdemoitsj.dto.ItemDto;
import com.example.shopdemoitsj.exception.ItemNotFoundException;
import com.example.shopdemoitsj.mapper.ItemMapper;
import com.example.shopdemoitsj.model.Item;
import com.example.shopdemoitsj.service.impl.ItemServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ItemControllerTest {

  @Mock ItemServiceImpl itemService;
  @InjectMocks ItemController itemController;

  Item item;
  ItemDto itemDto;

  @BeforeEach
  void init() {
    item = new Item(1, "go", 1234);
    itemDto = ItemMapper.getInstance().toDto(item);
  }

  @AfterEach
  void clean() {
    item = null;
    itemDto = null;
  }

  @Test
  @DisplayName("Junit test get all items")
  void getItems() {
    ItemDto itemDto1 = new ItemDto(2, "hoa", 123);
    List<ItemDto> itemDtoList = new ArrayList<>();
    itemDtoList.add(itemDto);
    itemDtoList.add(itemDto1);

    when(itemService.findAll()).thenReturn(itemDtoList);

    ResponseEntity<List<ItemDto>> result = itemController.getItems();

    assertThat(result.getBody()).hasSameSizeAs(itemDtoList);
    assertThat(result.getBody().get(0).getName()).isEqualTo(itemDtoList.get(0).getName());
    assertThat(result.getBody().get(1).getName()).isEqualTo(itemDtoList.get(1).getName());
  }

  @Test
  @DisplayName("Junit test get item by id ")
  void getItemById() throws ItemNotFoundException {
    when(itemService.findById(item.getId())).thenReturn(itemDto);

    ResponseEntity<ItemDto> result = itemController.getItemById(item.getId());

    assertThat(result.getBody()).isNotNull();
    assertThat(result.getBody().getName()).isEqualTo(itemDto.getName());
  }

  @Test
  @DisplayName("JUnit test save item")
  void save() {
    when(itemService.saveItem(itemDto)).thenReturn(itemDto);

    ResponseEntity<ItemDto> result = itemController.save(itemDto);

    assertThat(result.getBody()).isNotNull();
    assertThat(result.getBody().getName()).isEqualTo(itemDto.getName());
  }

  @Test
  @DisplayName("JUnit test update item")
  void update() throws ItemNotFoundException {
    when(itemService.saveItem(itemDto)).thenReturn(itemDto);
    itemDto.setName("update");
    ResponseEntity<ItemDto> result = itemController.update(itemDto);

    assertThat(result.getBody()).isNotNull();
    assertThat(result.getBody().getName()).isEqualTo("update");
  }

  @Test
  @DisplayName("Junit test delete item")
  void delete() throws Exception {

    when(itemService.delete(itemDto.getId())).thenReturn(new ResponseEntity<>(HttpStatus.OK));

    ResponseEntity<HttpStatus> result = itemController.delete(itemDto.getId());

    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);

    verify(itemService, times(1)).delete(itemDto.getId());
  }
}
