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

    }
}
