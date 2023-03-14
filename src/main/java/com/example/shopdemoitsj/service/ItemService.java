package com.example.shopdemoitsj.service;

import com.example.shopdemoitsj.model.Item;
import com.example.shopdemoitsj.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getItems(){
        return itemRepository.findAll();
    }
}
