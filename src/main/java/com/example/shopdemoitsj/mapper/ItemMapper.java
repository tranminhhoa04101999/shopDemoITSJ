package com.example.shopdemoitsj.mapper;

import com.example.shopdemoitsj.dto.ItemDTO;
import com.example.shopdemoitsj.model.Item;

public class ItemMapper {
    private static ItemMapper INSTANSE;

    public static ItemMapper getInstance(){
        if(INSTANSE == null){
            INSTANSE = new ItemMapper();
        }
        return INSTANSE;
    }
    public Item toEntity(ItemDTO dto){
        Item item = new Item();
        item.setId(dto.getId());
        item.setName(dto.getName());
        item.setPrice(dto.getPrice());
        return item;
    }

    public ItemDTO toDTO(Item item){
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setName(item.getName());
        itemDTO.setPrice(item.getPrice());
        return itemDTO;
    }
}
