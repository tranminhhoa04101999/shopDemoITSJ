package com.example.shopdemoitsj.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddToCartDTO {
    private int itemId;
    private int quantity;
    private int customerId;
}
