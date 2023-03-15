package com.example.shopdemoitsj.mapper;

import com.example.shopdemoitsj.dto.CartDTO;
import com.example.shopdemoitsj.dto.CartDetailDTO;
import com.example.shopdemoitsj.dto.CustomerDTO;
import com.example.shopdemoitsj.model.Cart;

import java.util.List;

public class CartMapper {
    private static CartMapper INSTANCE;

    public static CartMapper getInstance(){
        if(INSTANCE == null){
            INSTANCE = new CartMapper();
        }
        return INSTANCE;
    }

    public Cart toEntity(CartDTO cartDTO){
        Cart cart = new Cart();
        cart.setId(cartDTO.getId());
        cart.setCustomer(CustomerMapper.getInstance().toEntity(cartDTO.getCustomerDTO()));
        return cart;
    }
    public CartDTO toDTO (Cart cart, List<CartDetailDTO> cartDetailDTOList){
        CartDTO cartDTO = new CartDTO();
        cartDTO.setId(cart.getId());
        cartDTO.setCustomerDTO(CustomerMapper.getInstance().toDTO(cart.getCustomer()));
        cartDTO.setCartDetailDTOS(cartDetailDTOList);
        return cartDTO;
    }
}
