package com.example.shopdemoitsj.mapper;

import com.example.shopdemoitsj.dto.CartDetailDTO;
import com.example.shopdemoitsj.model.CartDetail;

public class CartDetailMapper {
    private static CartDetailMapper INSTANCE;

    public static CartDetailMapper getInstance(){
        if(INSTANCE == null){
            INSTANCE = new CartDetailMapper();
        }
        return INSTANCE;
    }
    public CartDetailDTO toDTO (CartDetail cartDetail){
        CartDetailDTO cartDetailDTO = new CartDetailDTO();
        cartDetailDTO.setId(cartDetail.getId());
        cartDetailDTO.setItemDTO(ItemMapper.getInstance().toDTO(cartDetail.getItem()));
        cartDetailDTO.setQuantity(cartDetail.getQuantity());
        cartDetailDTO.setDateAdded(cartDetail.getDateAdded());

        return cartDetailDTO;
    }


}
