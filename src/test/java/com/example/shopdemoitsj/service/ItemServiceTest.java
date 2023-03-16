package com.example.shopdemoitsj.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.shopdemoitsj.dto.ItemDto;
import com.example.shopdemoitsj.exception.ItemNotFoundException;

import com.example.shopdemoitsj.model.Item;
import com.example.shopdemoitsj.repository.ItemRepository;
import com.example.shopdemoitsj.service.impl.ItemServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {
  @Mock
  ItemRepository itemRepository;

  @InjectMocks
  ItemServiceImpl itemService;

  @Test
  void whenGetAll_shouldReturnList(){
    // create mock data
    List<Item> mockItems = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      mockItems.add(new Item(i));
    }
    // 2. define behavior of Repository
    when(itemRepository.findAll()).thenReturn(mockItems);

    // 3. call service method
    List<ItemDto> actualItems = itemService.findAll();

    // 4. assert the result
    assertThat(actualItems.size()).isEqualTo(mockItems.size());
    for (int i = 0; i < mockItems.size(); i++) {
      assertThat(actualItems.get(i).equals(mockItems.get(i)));
    }

    // 4.1 ensure repository is called
    verify(itemRepository).findAll();
  }
  @Test
  void whenFindById_shouldThrowException() {
    int invalidItemId = 7000;

    when(itemRepository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(null));

    assertThatThrownBy(() -> itemService.findById(invalidItemId))
        .isInstanceOf(ItemNotFoundException.class);

    verify(itemRepository).findById(any(Integer.class));
  }
  @Test
  void whenSave() {
    Item item = new Item();
    item.setId(1);
    item.setName("hoa");
    item.setPrice(1000);

    Item result = itemRepository.save(item);

    assertThat(result.getId()).isNotNull();

    verify(itemRepository).save(any(Item.class));

  }

}


























