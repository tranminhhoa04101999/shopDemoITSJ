package com.example.shopdemoitsj.service.impl;

import com.example.shopdemoitsj.dto.ItemDto;
import com.example.shopdemoitsj.exception.ItemNotFoundException;
import com.example.shopdemoitsj.mapper.ItemMapper;
import com.example.shopdemoitsj.model.Item;
import com.example.shopdemoitsj.repository.ItemRepository;
import com.example.shopdemoitsj.service.ItemService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * item service impl item interface.
 * */
@Service
public class ItemServiceImpl implements ItemService {
  @Autowired private ItemRepository itemRepository;

  @Override
  public List<ItemDto> findAll() {
    return itemRepository.findAll().stream()
        .map(item -> ItemMapper.getInstance().toDto(item))
        .collect(Collectors.toList());
  }

  @Override
  public ItemDto findById(int id) throws ItemNotFoundException {
    Item item;
    Optional<Item> itemOptional = itemRepository.findById(id);
    item = itemOptional.orElseGet(Item::new);

    if (itemOptional.isPresent()) {
      return ItemMapper.getInstance().toDto(item);
    } else {
      throw new ItemNotFoundException();
    }
  }

  @Override
  public void save(ItemDto itemDto) {
    itemRepository.save(ItemMapper.getInstance().toEntity(itemDto));
  }

  @Override
  public void delete(int itemId) {
    Item item = new Item();
    item.setId(itemId);
    itemRepository.delete(item);
  }
}
