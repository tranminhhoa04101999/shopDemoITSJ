package com.example.shopdemoitsj.repository;


import com.example.shopdemoitsj.model.Item;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ItemRepositoryTest {
  @Autowired
  private ItemRepository itemRepository;

  private Item itemInstance;

  @BeforeEach
  void init() {
    Item item = new Item(1,"name",1000);
    itemInstance = item;
  }
  @Test
  public void whenSave_thenReturnSaveItem() {
    Item item = itemRepository.save(itemInstance);

    assertThat(item).isNotNull();
    assertThat(item.getId()).isGreaterThan(0);
  }
  @Test
  public void whenFindAll_thenReturnSaveItem() {

    Item item1 = new Item(1,"name1",10000);
    Item item2 = new Item(2,"name1",10000);
    Item item3 = new Item(3,"name1",10000);

    itemRepository.save(item1);
    itemRepository.save(item2);
    itemRepository.save(item3);

    List<Item> result = itemRepository.findAll();
    assertThat(result.size()).isEqualTo(3);
  }

}