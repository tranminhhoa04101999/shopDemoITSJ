package com.example.shopdemoitsj.service;

import com.example.shopdemoitsj.dto.ItemDTO;
import com.example.shopdemoitsj.exception.ItemNotFoundException;

import java.util.List;

public interface ItemService {
    List<ItemDTO> findAll();

    ItemDTO findById(int id) throws ItemNotFoundException;

    void save(ItemDTO itemDTO);

    void delete(int itemId);
}
