package com.example.shopdemoitsj.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.shopdemoitsj.model.Item;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ItemRepositoryTest {
  @Autowired private ItemRepository itemRepository;

  private Item itemInstance;

  @BeforeEach
  void init() {
    Item item = new Item(1, "name", 1000);
    itemInstance = item;
  }

  @Test
  void whenSave_thenReturnSaveItem() {
    Item item = itemRepository.save(itemInstance);

    assertThat(item).isNotNull();
    assertThat(item.getId()).isPositive();
  }

  @Test
  void whenFindAll_thenReturnSaveItem() {

    Item item1 = new Item(1, "name1", 10000);
    Item item2 = new Item(2, "name1", 10000);
    Item item3 = new Item(3, "name1", 10000);

    itemRepository.save(item1);
    itemRepository.save(item2);
    itemRepository.save(item3);

    List<Item> result = itemRepository.findAll();
    assertThat(result).hasSize(3);
  }

  @Test
  @DisplayName("JUnit test find by id")
  void whenFindById_thenReturnItem() {
    Item item = itemInstance;
    Item itemTest = itemRepository.save(item);
    Item result = itemRepository.findById(item.getId()).get();
    assertThat(result).isEqualTo(itemTest);
  }

  @Test
  @DisplayName("JUnit test update item")
  void whenUpdate_thenReturnUpdateItem() {
    Item item = itemInstance;
    itemRepository.save(item);

    String newName = "hehe";
    item.setName(newName);
    itemRepository.save(item);
    Item result = itemRepository.findById(item.getId()).get();

    assertThat(result).isNotNull();
    assertThat(result.getName()).isEqualTo(newName);
  }

  @Test
  @DisplayName("JUnit test delete item")
  void whenDelete_thenRemoveItem() {
    Item item = itemInstance;
    Item itemTest = itemRepository.save(item);
    itemRepository.deleteById(itemTest.getId());
    Optional<Item> result = itemRepository.findById(itemTest.getId());
    assertThat(result).isEmpty();
  }
}
