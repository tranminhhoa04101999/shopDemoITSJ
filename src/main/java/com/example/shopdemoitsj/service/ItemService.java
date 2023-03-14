package com.example.shopdemoitsj.service;

import com.example.shopdemoitsj.dto.ItemDTO;
import com.example.shopdemoitsj.mapper.ItemMapper;
import com.example.shopdemoitsj.model.Item;
import com.example.shopdemoitsj.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<ItemDTO> findAll(){
        return itemRepository.findAll().stream().map(item -> ItemMapper.getInstance().toDTO(item)).collect(Collectors.toList());
    }
}
