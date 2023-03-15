package com.example.shopdemoitsj.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO implements Serializable {
    private int id;
    private CustomerDTO customerDTO;
    private List<CartDetailDTO> cartDetailDTOS;
}
