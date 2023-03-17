package com.example.shopdemoitsj.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.shopdemoitsj.dto.ItemDto;
import com.example.shopdemoitsj.exception.ItemNotFoundException;
import com.example.shopdemoitsj.mapper.ItemMapper;
import com.example.shopdemoitsj.model.Item;
import com.example.shopdemoitsj.repository.ItemRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ItemServiceImplTest {
  @Mock ItemRepository itemRepository;

  @InjectMocks ItemServiceImpl itemService;

  ItemDto itemDto;
  Item item;

  @BeforeEach
  void init() {
    item = new Item(2, "name", 1000);
    itemDto = ItemMapper.getInstance().toDto(item);
  }

  @AfterEach
  void clean() {
    item = null;
    itemDto = null;
  }

  @Test
  void whenFindAll_thenReturnList() {
    // create mock data
    List<Item> mockItems = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      mockItems.add(new Item(i, "name", 1000));
    }
    // 2. define behavior of Repository
    when(itemRepository.findAll()).thenReturn(mockItems);

    // 3. call service method
    List<ItemDto> actualItems = itemService.findAll();

    // 4. assert the result
    assertThat(actualItems).hasSameSizeAs(mockItems);
    for (int i = 0; i < mockItems.size(); i++) {
      assertThat(actualItems.get(i).equals(mockItems.get(i)));
    }

    // 4.1 ensure repository is called
    verify(itemRepository).findAll();
  }

  @Test
  void whenFindById_thenThrowException() {
    int invalidItemId = 7000;

    when(itemRepository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(null));

    assertThatThrownBy(() -> itemService.findById(invalidItemId))
        .isInstanceOf(ItemNotFoundException.class);

    verify(itemRepository).findById(any(Integer.class));
  }

  @Test
  @DisplayName("JUnit test save item serveci")
  void whenSave_thenReturn() {
    // precondition
    when(itemRepository.save(item)).thenReturn(item);
    //    // when
    ItemDto result = itemService.saveItem(itemDto);
    //    // then
    assertThat(result).isNotNull().isEqualTo(itemDto);

    verify(itemRepository).save(item);
  }

  @Test
  @DisplayName("JUnit test delete item by id ")
  void givenItemId_whenDelete_thenReturnTrue() {
    // precodition
    when(itemRepository.findById(item.getId())).thenReturn(Optional.of(item));
    doNothing().when(itemRepository).deleteById(item.getId());
    // when
    itemService.delete(item.getId());
    // then
    verify(itemRepository, times(1)).deleteById(item.getId());
  }

  //  @Test
  //  @DisplayName("JUNIT test update item By Id")
  //  void giveItemId_whenUpdate_thenReturnItemUpdate(){
  //    //precodition
  //    when(itemRepository.findById(item.getId())).thenReturn(Optional.of(item));
  //    item.setName("tenmoi");
  //    when(itemRepository.save(item)).thenReturn(item);
  //    ItemDto result = itemService.save(ItemMapper.getInstance().toDto(item));
  //    // when
  //    assertThat(result.getName()).isEqualTo(item.getName());
  //    // then
  //  }
}
