package com.example.shopdemoitsj.service.impl;

import com.example.shopdemoitsj.dto.ItemDTO;
import com.example.shopdemoitsj.exception.ItemNotFoundException;
import com.example.shopdemoitsj.mapper.ItemMapper;
import com.example.shopdemoitsj.model.Item;
import com.example.shopdemoitsj.repository.ItemRepository;
import com.example.shopdemoitsj.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<ItemDTO> findAll(){
        return itemRepository.findAll().stream().map(item -> ItemMapper.getInstance().toDTO(item)).collect(Collectors.toList());
    }

    @Override
    public ItemDTO findById(int id) throws ItemNotFoundException {
        if(itemRepository.findById(id).isPresent()){
            return ItemMapper.getInstance().toDTO(itemRepository.findById(id).get());
        }else{
            throw new ItemNotFoundException();
        }

    }
    @Override
    public void save(ItemDTO itemDTO){
        itemRepository.save(ItemMapper.getInstance().toEntity(itemDTO));
    }

    @Override
    public void delete(int itemId){
        Item item = new Item();
        item.setId(itemId);
        itemRepository.delete(item);
    }


}
